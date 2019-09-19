package http.exceptions;

public class InvalidUriQueryParamException extends IllegalArgumentException {

    private static final String INVALID_URI_QUERY_PARAM_MESSAGE = "URI의 쿼리가 잘 못 되었습니다.";

    public InvalidUriQueryParamException() {
        super(INVALID_URI_QUERY_PARAM_MESSAGE);
    }
}
