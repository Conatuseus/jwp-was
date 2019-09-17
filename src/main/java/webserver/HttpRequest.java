package webserver;

import java.util.Map;

public class HttpRequest {

    private String method;
    private String uri;
    private String version;
    private Map<String,String> headerFields;

    public HttpRequest(final String method, final String uri, final String version, final Map<String, String> headerFields) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.headerFields = headerFields;
    }
}
