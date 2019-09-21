package controller;

import http.HttpRequest;
import http.UriExtension;
import http.common.HttpHeader;
import http.response.HttpResponse;
import http.response.HttpStatus;
import http.response.Response200;
import http.response.ResponseBody;
import http.response.ResponseBodyParser;
import http.response.StatusLine;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    public HttpResponse doGet(HttpRequest httpRequest) throws IOException, URISyntaxException {
        StatusLine statusLine = new StatusLine(httpRequest.getHttpVersion(), HttpStatus.OK);

        String filePath = UriExtension.of(httpRequest.getPath())+ httpRequest.getPath();
        ResponseBody responseBody = ResponseBodyParser.parse(filePath);

        String contentType = new Tika().detect(filePath);
        HttpHeader responseHeader = new HttpHeader();
        responseHeader.putHeader("Content-Type", contentType);
        responseHeader.putHeader("Content-Length",Integer.toString(responseBody.getLength()));
        return new Response200(statusLine, responseHeader, responseBody);
    }
}
