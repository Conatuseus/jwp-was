package exception;

public class IllegalRequestHeaderException extends IllegalArgumentException {

    private static final String INVALID_REQUEST_HEADER_MESSAGE = "잘못된 request header입니다.";

    public IllegalRequestHeaderException() {
        super(INVALID_REQUEST_HEADER_MESSAGE);
    }
}
