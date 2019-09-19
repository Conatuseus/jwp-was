package utils.requestparser.requestlineparser;

import http.request.HttpMethod;
import http.request.HttpUri;
import http.request.HttpVersion;
import http.request.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestLineParser {

    private static final String BLANK = " ";

    public static RequestLine parseRequestLine(BufferedReader br) throws IOException {
        String[] requestLine = br.readLine().split(BLANK);

        HttpMethod httpMethod = HttpMethodParser.parseHttpMethod(requestLine[0]);
        HttpUri httpUri = HttpUriParser.parseUri(requestLine[1]);
        HttpVersion httpVersion = HttpVersion.of(requestLine[2]);

        return new RequestLine(httpMethod, httpUri, httpVersion);
    }
}
