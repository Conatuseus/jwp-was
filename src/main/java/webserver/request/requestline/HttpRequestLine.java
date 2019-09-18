package webserver.request.requestline;

public class HttpRequestLine {

    private HttpMethod method;
    private RequestUri requestUri;
    private String version;

    public HttpRequestLine(final String method, final String uri, final String version) {
        this.method = HttpMethod.valueOf(method);
        this.requestUri = new RequestUri(uri);
        this.version = version;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String findFilePath() {
        return requestUri.findUriPrefix() + requestUri.getUri();
    }
}
