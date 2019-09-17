package utils;

import exception.IllegalRequestHeaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHeader;

import java.io.BufferedReader;
import java.io.IOException;

public class IOUtils {

    private static final Logger logger = LoggerFactory.getLogger(IOUtils.class);
    private static final String DELIMITER = ":";
    private static final int SPLIT_LIMIT = 2;
    private static final String EMPTY = "";

    /**
     * @param BufferedReader는 Request Body를 시작하는 시점이어야
     * @param contentLength는  Request Header의 Content-Length 값이다.
     * @return
     * @throws IOException
     */
    public static String readData(BufferedReader br, int contentLength) throws IOException {
        char[] body = new char[contentLength];
        br.read(body, 0, contentLength);
        return String.copyValueOf(body);
    }

    public static RequestHeader readRequestHeader(BufferedReader br) throws IOException {
        RequestHeader requestHeader = new RequestHeader();

        String line = br.readLine();
        checkRequestHeader(line);

        logger.debug("request : {}", line);
        requestHeader.addField(RequestHeader.REQUEST_HEADER_FIRST_LINE_NAME, line);

        line = br.readLine();
        while (isValidLine(line)) {
            logger.debug("request : {}", line);

            String[] tokens = line.split(DELIMITER, SPLIT_LIMIT);
            requestHeader.addField(tokens[0].trim(), tokens[1].trim());
            line = br.readLine();
        }
        return requestHeader;
    }

    private static void checkRequestHeader(String line) {
        if (line == null) {
            throw new IllegalRequestHeaderException();
        }
    }

    private static boolean isValidLine(String line) {
        return line != null && !EMPTY.equals(line);
    }
}
