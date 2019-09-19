package http.request;

import http.exceptions.InvalidHttpVersionException;

import java.util.Arrays;

public enum HttpVersion {
    HTTP_0_9("HTTP/0.9"), HTTP_1_0("HTTP/1.0"), HTTP_1_1("HTTP/1.1"), HTTP_2_0("HTTP/2.0");

    private String version;

    HttpVersion(String version) {
        this.version = version;
    }

    public static HttpVersion of(String version) {
        return Arrays.stream(HttpVersion.values()).filter(httpVersion -> httpVersion.isSameVersion(version))
            .findFirst()
            .orElseThrow(InvalidHttpVersionException::new);
    }

    private boolean isSameVersion(String version) {
        return this.version.equals(version);
    }
}
