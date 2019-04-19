package main.com.imooc.utils;

import java.util.Map;

public class HttpClientResponse {
    /**
    *响应状态码
    */
    private String statusCode;

    /**
    *响应头Headers
    */
    private Map<String,String> headers;
    /**
    *响应body
    */
    private String body;

    public String getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
