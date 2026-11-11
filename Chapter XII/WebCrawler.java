import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

public class WebCrawler {
    final private static int PAGES_LIMIT = 1000;
    private static int visitedPages = 0;
    final private static ArrayList<String> allURLs = new ArrayList<>();
    final private static Stack pendingURLs = new Stack();

    /**
     * Crawl through all of the found URLs
     */
    private static void crawler(String url) throws MalformedURLException, IOException, InterruptedException {
        try {
            URL initURL = new URL(url);
            ArrayList<String> foundURLs = new ArrayList<>();

            // timeout every 10th pages of pages limit
            if (visitedPages % (PAGES_LIMIT / 10) == 0 && visitedPages != 0) {
                // Show the links while we wait
                for (String s : allURLs) System.out.println(s);
                Thread.sleep(10_000); //Sleep for 10s
            }

            // check if URL returns 200
            if (validURL(initURL)) {
                foundURLs = (readHTML(initURL));
            } else {
                // call back crawler with the next URL in line
                if (visitedPages != PAGES_LIMIT) { 
                    if (pendingURLs.getSize() > 0) pendingURLs.pop();
                    crawler(pendingURLs.peek().toString());
                }
            }
                

            // append the found URLs to the list of URLs and the pending URLs
            for (String found : foundURLs) { 
                allURLs.add(found);
                pendingURLs.push(found);
            }

            if (visitedPages != PAGES_LIMIT) { 
                pendingURLs.pop();
                crawler(pendingURLs.peek().toString());
            } else {
                System.out.printf("%d URLs found.\n", allURLs.size());
                System.out.printf("URLs to be crawled: %d", pendingURLs.getSize());
                System.exit(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a collection of all of URLs within a HTML 
     */
    private static ArrayList<String> readHTML(URL url) throws IOException {
        // count the page visit
        visitedPages++;
        System.out.printf("We are on page %d\n", visitedPages);
        
        ArrayList<String> tempUrlList = new ArrayList<>();
        try (Scanner input = new Scanner(url.openStream());) {
            String s = "";
            while(input.hasNext()) {
                try {
                    s = input.next();
                    if (s.startsWith("https://") && !allURLs.contains(s)) { 
                        tempUrlList.add(s.substring(1));
                    } else if (s.startsWith("href=") && !allURLs.contains(s)) {
                        s = (s.lastIndexOf('"') == s.indexOf('"')) 
                            ? s.substring(6) 
                            : s.substring(6, s.lastIndexOf('"'));

                        s = s.replaceAll("^[\"\\\\]+|[\"\\\\]+$", "");
                        tempUrlList.add(s);
                    }
                } catch (Exception e) {
                    System.out.println(s);
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        return tempUrlList;
    }

    /**
     * Return a boolean value that determines if the URL is valid
     */
    private static boolean validURL(URL url) throws IOException {
        if (url.toString().startsWith("https://")) {
            HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
            return getResponse(huc);
        } else if (url.toString().startsWith("http://")) {
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            return getResponse(huc);
        }
        return false;
    }

    /**
     * Receives a GET response from the URL and returns a boolean value depending on if the response code is 200 or not
     */
    private static <T extends HttpURLConnection> boolean getResponse(T huc) {
        try {
            huc.setRequestMethod("GET");
            int response = huc.getResponseCode();
            return response == 200;
        } catch (IOException e) {
            System.out.println(huc.getURL());
            e.printStackTrace();
            System.exit(2);
        }
        return false;
    }

    public static void main(String arg[]) throws MalformedURLException, IOException, InterruptedException {
        String initURL = "https://www.geeksforgeeks.org/java/arrays-sort-in-java/";
        crawler(initURL);
    }
}

/**
 * Custom Stack structure
 */
class Stack {
    final private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int getSize() {
        return this.list.size();
    }

    public Object peek() {
        return this.list.get(getSize() - 1);
    }

    public Object pop() {
        int index = getSize() - 1;
        Object o = list.get(index);
        this.list.remove(index);
        return o;
    }

    public void push(Object o) {
        this.list.add(o);
    }
}
