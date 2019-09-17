package webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.FileIoUtils;
import utils.IOUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
            connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            // TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            RequestHeader requestHeader = IOUtils.readRequestHeader(br);

            String requestLine = requestHeader.getField(IOUtils.REQUEST_HEADER_FIRST_LINE_NAME);
            String[] tokens = requestLine.split(" ");

            String url = null;
            if ("GET".equals(tokens[0])) {
                url = tokens[1];
            }

            String urlPrefix = "./static";
            String[] urlTokens = url.split("\\.");
            String lastUrlToken = urlTokens[urlTokens.length - 1];
            if ("html".equals(lastUrlToken) || "ico".equals(lastUrlToken)) {
                urlPrefix = "./templates";
            }

            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = FileIoUtils.loadFileFromClasspath(urlPrefix + url);
            if ("js".equals(lastUrlToken)) {
                response200Header(dos, body.length, "javascript");
            } else {
                response200Header(dos, body.length, lastUrlToken);
            }
            responseBody(dos, body);
        } catch (IOException | URISyntaxException e) {
            logger.error(e.getMessage());
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent, String abc) throws IOException {
        dos.writeBytes("HTTP/1.1 200 OK \r\n");
        dos.writeBytes("Content-Type: text/" + abc + ";charset=utf-8\r\n");
        dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
        dos.writeBytes("\r\n");
    }

    private void responseBody(DataOutputStream dos, byte[] body) throws IOException {
        dos.write(body, 0, body.length);
        dos.flush();
    }
}
