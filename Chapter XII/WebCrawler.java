import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class WebCrawler {
    final private static int PAGES_LIMIT = 100;
    
    private static int visitedPages = 0;
    final private static ArrayList<String> allURLs = new ArrayList<>();
    final private static Stack pendingURLs = new Stack();

    /**
     * Removes the current URL from the pendingURLs stack
     * Calls the crawler with the next pending URL in the stack
     */
    public static void crawlerRecursiveCall() 
        throws IOException, InterruptedException, URISyntaxException {
        
        if (visitedPages != PAGES_LIMIT) { 
            if (!pendingURLs.isEmpty()) { 
                pendingURLs.pop();
                crawler(pendingURLs.peek().toString());
            }
            else {
                System.out.println("No pending URLs.");
                System.exit(1);
            }
        }
    }
    
    /**
     * Crawl through all of the found URLs
     */
    private static void crawler(String url) 
        throws IOException, InterruptedException, MalformedInputException, URISyntaxException {
        
        URI initURI = new URI(url);
        URL initURL = initURI.toURL();
        ArrayList<String> foundURLs = new ArrayList<>();

        // timeout every 10th pages to be polite
        if (visitedPages % (PAGES_LIMIT / 10) == 0 && visitedPages != 0) {
            // Show the links while we wait
            for (String s : allURLs) System.out.println(s);
            Thread.sleep(10_000); //Sleep for 10s
        }

        // read the HTML of the page if its valid
        if (validURL(initURL)) {
            foundURLs = (readHTML(initURL));
        } else {
            // call back crawler with the next pending URL
            crawlerRecursiveCall();
        }
            
        // append the found URLs to the list of URLs and the pending URLs
        if (!foundURLs.isEmpty()) {
            for (String found : foundURLs) { 
                allURLs.add(found);
                pendingURLs.push(found);
            }

            writeToFile();
        }

        // remove the current URL from pending, call the crawler with the next pending URL
        crawlerRecursiveCall();
    }

    /**
     * Reads the HTML code of a page token-by-token. Separates URLs from meaningless tokens to the crawler. 
     * Automatically closes the URL connection. 
     @return ArrayList of formatted URLs.
     */
    private static ArrayList<String> readHTML(URL url)
        throws IOException {
        
        // count the page visit
        visitedPages++;
        System.out.printf("We are on page %d, currently visiting: %s\n", visitedPages, url.toString());
        
        ArrayList<String> tempURLList = new ArrayList<>();
        try (Scanner input = new Scanner(url.openStream());) {
            while(input.hasNext()) {
                String s = input.next();
                if (s.contains("https://") || s.contains("http://")) {
                    String foundURL = findURL(s).replace('\\', ' ').trim();
                    if (foundURL != null 
                        && !(allURLs.contains(foundURL) || tempURLList.contains(foundURL))
                        && !(foundURL.contains(".svg") || foundURL.contains(".png") || foundURL.contains(".webp") || foundURL.contains(".jpg") || foundURL.contains(".jpeg"))) { 
                        tempURLList.add(foundURL);
                    }
                }
            }
        }
        return tempURLList;
    }

    /**
     * Finds an URL within a token.
        @return String that matches the URL regex
     */
    private static String findURL(String s) {
        Pattern p = Pattern.compile("https?://[^\\s\"'<>\\\\]+");
        Matcher m = p.matcher(s);

        while (m.find()) {
            return m.group();
        }
        
        return null;
    }

    /**
     * Receives a URL object and creates an HttpURLConnection or HttpsURLConnection instance based on the URL protocol. 
     * Sets connection timeouts to avoid timeout issues, and calls getResponse(T huc). 
        @return Boolean representing the validity of the URL
     */
    private static boolean validURL(URL url) 
        throws IOException, SocketTimeoutException {
        
        HttpURLConnection huc = url.toString().startsWith("https://") 
            ? (HttpsURLConnection) url.openConnection() 
            : (HttpURLConnection) url.openConnection();

        huc.setConnectTimeout(3000);
        huc.setReadTimeout(7000);

        return getResponse(huc);
    }
    /**
     * Receives a String object, creates a URL object, and creates an HttpURLConnection or HttpsURLConnection instance based on the URL protocol. 
     * Sets connection timeouts to avoid timeout issues, and calls getResponse(T huc). 
        @return Boolean representing the validity of the URL
     */
    private static boolean validURL(String s) 
        throws IOException, SocketTimeoutException, MalformedURLException, URISyntaxException {
        
        URI uri = new URI(s);
        URL url = uri.toURL();
        
        HttpURLConnection huc = url.toString().startsWith("https://") 
            ? (HttpsURLConnection) url.openConnection() 
            : (HttpURLConnection) url.openConnection();

        huc.setConnectTimeout(3000);
        huc.setReadTimeout(7000);

        return getResponse(huc);
    }

    /**
     *  Receives a HTTP / HTTPS URL connection instance and sends a GET request
        @return Boolean representing the code of the response
     */
    private static <T extends HttpURLConnection> boolean getResponse(T huc)
        throws IOException {
        
        huc.setRequestMethod("GET");
        int response = huc.getResponseCode();
        return response == 200;
    }

    /**
     * Creates a .txt file at the specified path and writes all found URLs to that txt file
     */
    public static void writeToFile()
        throws FileNotFoundException {

        String path = "output.txt";
        try (PrintWriter output = new PrintWriter(path);) {
            for (String url : allURLs) {
                output.write(url + "\n");
            }
        }
    }

    public static void main(String args[]) 
        throws IOException, InterruptedException, URISyntaxException {
        
        if (args.length == 0) System.out.println("USAGE: java WebCrawler.java <inputFile.txt> OR <initURL>");
        else {
            // Check if URL, otherwise treat as file path
            if (args[0].startsWith("http://") || args[0].startsWith("https://")) crawler(args[0]);
            else {
                Path path = Paths.get(args[0]);
                if (Files.exists(path)) {
                    System.out.println("File exists");
                    // Assign first URL as initURL, the rest of the URLs are added to pendingURLs
                    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                        String line;
                        
                        while ((line = reader.readLine()) != null) {
                            pendingURLs.push(line);
                        }
                        
                        crawler(pendingURLs.peek().toString());
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                }
            }
        }
        
    }
}

/**
 * Custom Stack structure that extends the ArrayList class
 */
class Stack extends ArrayList<Object> {
    public int getSize() {
        return this.size();
    }

    public Object peek() {
        return this.get(getSize() - 1);
    }

    public Object pop() {
        int index = getSize() - 1;
        Object o = this.get(index);
        this.remove(index);
        return o;
    }

    public void push(Object o) {
        this.add(o);
    }
}
