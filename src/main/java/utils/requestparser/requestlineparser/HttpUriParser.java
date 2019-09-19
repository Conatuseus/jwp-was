package utils.requestparser.requestlineparser;

import http.request.HttpUri;
import utils.QueryParser;

import java.util.HashMap;
import java.util.Map;

public class HttpUriParser {

    public static HttpUri parseUri(String uri) {
        boolean hasQueryParams = uri.contains("\\?");
        Map<String, String> params = new HashMap<>();

        if (hasQueryParams) {
            params = QueryParser.parseParam(uri);
        }
        return new HttpUri(uri, hasQueryParams, params);
    }
}
