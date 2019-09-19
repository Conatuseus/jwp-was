package http.request;

import java.util.Map;

public class RequestEntityBody {

    private Map<String, String> entityBody;

    public RequestEntityBody(final Map<String, String> entityBody) {
        this.entityBody = entityBody;
    }
}
