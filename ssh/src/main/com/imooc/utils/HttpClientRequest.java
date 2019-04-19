package main.com.imooc.utils;

import org.apache.http.client.methods.HttpUriRequest;

import java.util.Map;

public class HttpClientRequest {
    /**
    *请求地址
    */
    private String url;
    
    /**
    *请求方法
    */
//    private HttpUriRequest httpMethod;
    /**
    *请求头Header
    */
    private Map<String,String> headers;
    /**
    *请求body
    */
    private String body;

    public void setUrl(String url) {
        this.url = url;
    }
//
//    public void setHttpMethod(HttpUriRequest httpMethod) {
//        this.httpMethod = httpMethod;
//    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

//    public HttpUriRequest getHttpMethod() {
//        return httpMethod;
//    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
