package testing.junitVsSpock;

/**
 * @author Piotrek
 */
public class MyUrlValidator {
    private boolean allowFileUrls = false;

    public void allowFileUrls(boolean allowFileUrls) {
        this.allowFileUrls = allowFileUrls;
    }

    public boolean isValidUrl(String url) {
        return url.equals("http://www.google.com") || allowFileUrls && url.startsWith("file:");
    }
}
