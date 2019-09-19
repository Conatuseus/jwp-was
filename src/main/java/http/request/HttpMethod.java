package http.request;

import http.exceptions.InvalidHttpMethodException;

public enum HttpMethod {
    GET, POST, PUT, DELETE;

    public static HttpMethod of(String httpMethod) {
        try{
            return HttpMethod.valueOf(httpMethod);
        }
        catch (IllegalArgumentException e){
            throw new InvalidHttpMethodException();
        }
    }
}
