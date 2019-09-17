package webserver;

import java.util.HashMap;
import java.util.Map;

public class RequestHeader {

    private Map<String, String> fields = new HashMap<>();

    public String getField(String name) {
        return fields.get(name);
    }

    public void addField(String name, String value) {
        fields.put(name,value);
    }
}
