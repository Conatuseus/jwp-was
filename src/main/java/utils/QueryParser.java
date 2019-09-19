package utils;

import http.exceptions.InvalidUriQueryParamException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueryParser {

    private static final String QUERY_PARAMS_DELIMITER = "&";
    private static final String PARAM_DELIMITER = "=";
    private static final int PARAM_SIZE = 2;

    public static final Map<String, String> parseParam(String queryParams) {
        Map<String, String> params = new HashMap<>();

        Arrays.stream(queryParams.split(QUERY_PARAMS_DELIMITER))
            .forEach(query -> {
                    String[] param = query.split(PARAM_DELIMITER);
                    if (param.length != PARAM_SIZE) {
                        throw new InvalidUriQueryParamException();
                    }
                    params.put(param[0], param[1]);
                }
            );

        return params;
    }
}
