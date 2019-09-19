package http.request;

import java.util.Map;

public class RequestHeader {

    private Map<String, String> headers;

    public RequestHeader(final Map<String, String> headers) {
        this.headers = headers;
    }
}
