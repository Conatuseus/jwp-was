package http.exceptions;

public class InvalidHttpVersionException extends IllegalArgumentException {

    private static final String INVALID_HTTP_VERSION_MESSAGE = "잘못된 HTTP 버전입니다.";

    public InvalidHttpVersionException() {
        super(INVALID_HTTP_VERSION_MESSAGE);
    }
}
