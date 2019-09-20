package http;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RequestHeaderTest {

    @Test
    void create_request_header() {
        List<String> headers = Arrays.asList("Host: localhost:8080",
            "Connection: keep-alive",
            "Accept: */*");

        Map<String, String> header = new HashMap<>();
        headers.stream().forEach(params -> {
            String[] paramTokens = params.split(":", 2);
            header.put(paramTokens[0], paramTokens[1]);
        });

        assertDoesNotThrow(() -> new RequestHeader(header));
    }

    @Test
    void find_header() {
        List<String> headers = Arrays.asList("Host: localhost:8080",
            "Connection: keep-alive",
            "Accept: */*");
        RequestHeader requestHeader = RequestHeaderParser.parse(headers);
        assertThat(requestHeader.findHeader("Connection")).isEqualTo("keep-alive");
    }
}