package org.coursework.base;

import java.net.URI;
import java.net.URISyntaxException;

import static org.coursework.config.EnvConfig.*;

public class BaseAPITest {
    static public URI getAPIURL() {
        String url = HTTP_BASE_PROTOCOL.value + "://" + HTTP_BASE_URL.value + ":" + HTTP_BASE_PORT.value +"/jsonrpc.php";
        //String url = getBaseURL() + ":" + HTTP_BASE_PORT.value +"/jsonrpc.php";
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException("URL has wrong format: " + url, e);
        }
    }
}
