package utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHeader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class IOUtilsTest {


    private static final Logger logger = LoggerFactory.getLogger(IOUtilsTest.class);

    @Test
    public void readData() throws Exception {
        String data = "abcd123";
        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);

        logger.debug("parse body : {}", IOUtils.readData(br, data.length()));
    }

    @Test
    void readRequestHeader() throws IOException {
        String header = "GET /index.html HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "Connection: keep-alive\n";
        InputStream stream = new ByteArrayInputStream(header.getBytes(StandardCharsets.UTF_8));
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));

        RequestHeader requestHeader = IOUtils.readRequestHeader(br);
        assertThat(requestHeader.getField(IOUtils.REQUEST_HEADER_FIRST_LINE_NAME)).isEqualTo("GET /index.html HTTP/1.1");
        assertThat(requestHeader.getField("Host")).isEqualTo("localhost:8080");
        assertThat(requestHeader.getField("Connection")).isEqualTo("keep-alive");
    }
}
