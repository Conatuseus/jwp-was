package utils.requestparser.requestlineparser;

import http.request.HttpMethod;

public class HttpMethodParser {

    public static HttpMethod parseHttpMethod(String httpMethod) {
        return HttpMethod.of(httpMethod);
    }
}
