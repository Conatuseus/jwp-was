package webserver;

public class RequestHeaderHandler {

    private static final String BLANK = " ";
    private static final int HTTP_METHOD_INDEX = 0;
    private static final int HTTP_URL_INDEX = 1;
    private static final String TEMPLATES_PATH = "./templates";
    private static final String STATIC_PATH = "./static";
    private static final String HTML_EXTENSION = "html";
    private static final String ICO_EXTENSION = "ico";
    private static final String URL_DELIMITER = "\\.";

    public static String findHttpMethod(RequestHeader requestHeader) {
        return getToken(requestHeader, HTTP_METHOD_INDEX);
    }

    public static String findHttpUrl(RequestHeader requestHeader) {
        return getToken(requestHeader, HTTP_URL_INDEX);
    }

    private static String getToken(RequestHeader requestHeader, int index) {
        String[] tokens = splitRequestLine(requestHeader);
        return tokens[index];
    }

    private static String[] splitRequestLine(RequestHeader requestHeader) {
        String requestLine = requestHeader.getField(RequestHeader.REQUEST_HEADER_FIRST_LINE_NAME);
        return requestLine.split(BLANK);
    }
    
    public static String findHttpUrlPrefix(RequestHeader requestHeader) {
        String urlExtension = findHttpUrlExtension(requestHeader);

        if (HTML_EXTENSION.equals(urlExtension) || ICO_EXTENSION.equals(urlExtension)) {
            return TEMPLATES_PATH;
        }
        return STATIC_PATH;
    }

    public static String findHttpUrlExtension(RequestHeader requestHeader) {
        String url = findHttpUrl(requestHeader);

        String[] urlTokens = url.split(URL_DELIMITER);
        int indexOfExtension = urlTokens.length - 1;
        return urlTokens[indexOfExtension];
    }
}
