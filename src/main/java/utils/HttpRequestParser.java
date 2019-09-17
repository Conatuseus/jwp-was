package utils;

import webserver.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestParser {

    public static HttpRequest parseHttpRequest(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        List<String> splitFirstLine = parseFirstLine(br.readLine());

        String httpMethod = splitFirstLine.get(0);
        String uri = splitFirstLine.get(1);
        String version = splitFirstLine.get(2);

        Map<String, String> headFields = new HashMap<>();

        String line = br.readLine();
        while (line != null && !"".equals(line)) {
            List<String> headerField = parseHeaderField(line);
            addHeaderField(headFields, headerField);
            line = br.readLine();
        }

        return new HttpRequest(httpMethod, uri, version, headFields);
    }

    private static List<String> parseFirstLine(String line) {
        return Arrays.asList(line.split(" "));
    }

    private static List<String> parseHeaderField(String headerFieldLine) {
        return Arrays.asList(headerFieldLine.split(":", 2));
    }

    private static void addHeaderField(final Map<String, String> headerField, final List<String> splitHeaderField) {
        String headerFieldName = splitHeaderField.get(0).trim();
        String headerFieldValue = splitHeaderField.get(1).trim();
        headerField.put(headerFieldName, headerFieldValue);
    }
}
