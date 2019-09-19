package http.request;

public class RequestLine {

    private HttpMethod httpMethod;
    private HttpUri httpUri;
    private HttpVersion httpVersion;

    public RequestLine(final HttpMethod httpMethod, final HttpUri httpUri, final HttpVersion httpVersion) {
        this.httpMethod = httpMethod;
        this.httpUri = httpUri;
        this.httpVersion = httpVersion;
    }
}
