package http.request;

import java.util.Map;

public class HttpUri {

    private String uri;
    private boolean hasQueryParams;
    private Map<String, String> params;

    public HttpUri(final String uri, final boolean hasQueryParams, final Map<String, String> params) {
        this.uri = uri;
        this.hasQueryParams = hasQueryParams;
        this.params = params;
    }
}
