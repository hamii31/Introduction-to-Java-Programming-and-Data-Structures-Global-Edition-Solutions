import java.io.*;
import java.net.*;
import java.nio.charset.MalformedInputException;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * TO-DO: Split big chunks of JSON and get only the URLs from it
 */
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
        throws IOException, InterruptedException {
        
        if (visitedPages != PAGES_LIMIT) { 
            if (pendingURLs.getSize() > 0) { 
                pendingURLs.pop();
            }
            crawler(pendingURLs.peek().toString());
        }
    }
    
    /**
     * Crawl through all of the found URLs
     */
    private static void crawler(String url) 
        throws IOException, InterruptedException, MalformedInputException {
        
        URL initURL = new URL(url);
        ArrayList<String> foundURLs = new ArrayList<>();

        // timeout every 10th pages
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
        for (String found : foundURLs) { 
            allURLs.add(found);
            pendingURLs.push(found);
        }

        // remove the current URL from pending, call the crawler with the next pending URL
        crawlerRecursiveCall();
    }

    /**
     * Reads the HTML code of a page token-by-token. Separates URLs from meaningless tokens. 
     * Automatically closes the URL connection. 
     @return ArrayList of formatted URLs.
     */
    private static ArrayList<String> readHTML(URL url)
        throws IOException {
        
        // count the page visit
        visitedPages++;
        System.out.printf("We are on page %d\n", visitedPages);
        
        ArrayList<String> tempUrlList = new ArrayList<>();
        try (Scanner input = new Scanner(url.openStream());) {
            while(input.hasNext()) {
                String s = input.next();
                if (s.contains("https://") || s.contains("http://")) {
                    String formattedURL = formatURL(s);
                    if (formattedURL != null) { 
                        tempUrlList.add(formattedURL);
                    }
                }
            }
        }
        return tempUrlList;
    }

    /**
     *  Formats the given string (if its an URL)
     *  Removes any whitespace, ", ' or \ at the start
     *  Removes any mix of literal \n, \r or \t, whitespace, ", ', , or \, in any order and any number at the end
     *  FIX THIS MESS
        @return Formatted URL string
     */
    private static String formatURL(String s) {
        s = s.replaceAll("^[\\s\"'\\\\]+|(?:\\\\[nrt]|[\\s\"',\\\\])+$", "");

        if (s.startsWith("https://") || s.startsWith("http://")) { 
            if (!(s.endsWith(".jpg") || s.endsWith(".png") || s.endsWith(".webp")) // ignore images 
            && !allURLs.contains(s)) {
                if (s.contains(">")) {
                    String[] splitted = s.split(">");
                    s = splitted[0];
                }
                return s;
            }
               
        } else if (s.startsWith("href=")) {
            s = s.substring(6);
            return formatURL(s);
        }
        return null;
    }

    /**
     * Creates an HttpURLConnection or HttpsURLConnection instance based on the URL protocol. 
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
     *  Receives a HTTP / HTTPS URL connection instance and sends a GET request
        @return Boolean representing the code of the response
     */
    private static <T extends HttpURLConnection> boolean getResponse(T huc)
        throws IOException {
        
        huc.setRequestMethod("GET");
        int response = huc.getResponseCode();
        return response == 200;
    }

    public static void main(String arg[]) 
        throws IOException, InterruptedException {
        
        String initURL = "https://www.geeksforgeeks.org/java/arrays-sort-in-java/";
        crawler(initURL);
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
