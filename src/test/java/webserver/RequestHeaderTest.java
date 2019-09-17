package webserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RequestHeaderTest {

    private RequestHeader requestHeader;

    @BeforeEach
    void setUp() {
        requestHeader = new RequestHeader();
    }

    @Test
    void addAndGetField() {
        String name = "Host";
        String value = "localhost:8080";

        requestHeader.addField(name, value);
        assertThat(requestHeader.getField(name)).isEqualTo(value);
    }

}