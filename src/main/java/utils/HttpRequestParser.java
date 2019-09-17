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

        // HTTP request 첫째 줄(상태 라인)엔 httpMethod, uri, 프로토콜 version이 있음
        String httpMethod = splitFirstLine.get(0);
        String uri = splitFirstLine.get(1);
        String version = splitFirstLine.get(2);

        // 리퀘스트 헤더 필드
        Map<String, String> headerFields = new HashMap<>();

        //이 부분도 메서드로 빼고 싶음.
        String line = br.readLine();
        while (line != null && !"".equals(line)) {
            List<String> headerField = parseHeaderField(line);
            addHeaderField(headerFields, headerField);
            line = br.readLine();
        }

        return new HttpRequest(httpMethod, uri, version, headerFields);
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
