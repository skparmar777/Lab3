 import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;

    /**
     * @author Sejal
     */
    public class Lab3 {
     /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

/**
 * @author Sejal
 * @param args []
 */
    public static void main(final String[] args) {
        //prompts user input for a url
        System.out.println("Enter a URL: ");
        Scanner sc = new Scanner(System.in);
        String link = sc.nextLine();

        String content = urlToString(link);

        int wordCount = 0;

        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == ' ') {
                wordCount++;
            }
        }
        System.out.println("The word count is: " + wordCount + " words");

        System.out.println("Search for the amount of occurences of a word: ");

        System.out.println("Enter your search word: ");
        String search = sc.nextLine();

        int count = content.split(search).length - 1;

        System.out.println("The word " + "'" + search + "' appears " + count + " times.");

        sc.close();
    } //end main

} //end class
