package webserver;

import java.util.HashMap;
import java.util.Map;

public class RequestHeader {

    public static final String REQUEST_HEADER_FIRST_LINE_NAME = "Request-Line";
    private Map<String, String> fields = new HashMap<>();

    public String getField(String name) {
        return fields.get(name);
    }

    public void addField(String name, String value) {
        fields.put(name,value);
    }
}
