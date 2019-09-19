package http.exceptions;

public class InvalidHttpMethodException extends IllegalArgumentException {

    private static final String INVALID_HTTP_METHOD_MESSAGE = "잘못된 HTTP method 입니다.";

    public InvalidHttpMethodException() {
        super(INVALID_HTTP_METHOD_MESSAGE);
    }
}
