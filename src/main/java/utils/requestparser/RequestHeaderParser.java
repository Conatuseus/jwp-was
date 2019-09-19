package utils.requestparser;

import http.request.RequestHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHeaderParser {

    private static final String EMPTY = "";
    private static final String NEW_LINE = "\n";

    public static RequestHeader parseHeader(BufferedReader br) throws IOException {
        Map<String, String> headers = new HashMap<>();

        String line = br.readLine();
        while (isValidLine(line)) {
            String[] headerTokens = line.split(":");
            String name = headerTokens[0].trim();
            String value = headerTokens[1].trim();

            headers.put(name, value);
            line = br.readLine();
        }
        return new RequestHeader(headers);
    }

    private static boolean isValidLine(final String line) {
        return line != null && !EMPTY.equals(line) && !NEW_LINE.equals(line);
    }
}
