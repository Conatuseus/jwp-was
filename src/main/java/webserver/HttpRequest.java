package webserver;

import java.util.Map;

public class HttpRequest {

    // 첫째 줄(상태 라인)에 있는 것들. 이 3개를 status 라는 객체로 빼도 될듯?
    private String method;
    private String uri;
    private String version;

    // 리퀘스트 헤더 필드
    private Map<String,String> headerFields;

    public HttpRequest(final String method, final String uri, final String version, final Map<String, String> headerFields) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.headerFields = headerFields;
    }
}
