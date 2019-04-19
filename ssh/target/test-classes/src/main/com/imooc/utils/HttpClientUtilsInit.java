package main.com.imooc.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtilsInit {
    public static Logger logger = Logger.getLogger(HttpClientUtilsInit.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        HttpClientUtilsInit httpClientUtils = new HttpClientUtilsInit();
//        httpClientUtils.testMethodGet();
        System.out.println("===================================");
//        httpClientUtils.testMethodPost();
        HttpClientRequest httpClientRequest = new HttpClientRequest();
        String userName="张三";
//        String url ="http://127.0.0.1:8082/gril/springboot/postDemo?userName="+userName;
        int id=1;
        String url = "http://127.0.0.1:8082/gril/springboot/hello?id="+id;
        httpClientRequest.setUrl(url);
        Map<String, String> reqeustHeaders = new HashMap<String, String>();
        reqeustHeaders.put("Content-Type", "text/html;charset=UTF-8");
        httpClientRequest.setHeaders(reqeustHeaders);
        httpClientRequest.setBody("post body test String");
//        httpClientUtils.doPost(httpClientRequest);
          httpClientUtils.doGet(httpClientRequest);
    }

    /**
     * 测试get请求方法
     */
    public void testMethodGet() {
        //1，初始、创建http请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //2.定义请求的唯一标识
        String url = "http://127.0.0.1:8082/gril/springboot/hello";
        //3,定义请求对象
        HttpGet httpGet = new HttpGet(url);
        //4，发送请求消息
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //获取响应的状态
            logger.info("========响应状态============" + response.getStatusLine().toString().split(" ")[1]);
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                logger.info("========响应Header=name============" + header.getName());
                logger.info("========响应Header=value===========" + header.getValue());
            }
            HttpEntity httpEntity = response.getEntity();
            String body1 = IOUtils.toString(httpEntity.getContent(), "utf-8");
            logger.info("========响应内容=body1===========" + body1);
            //5,关闭请求
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试post请求方法
     */
    public void testMethodPost() {
        //1，初始、创建http请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //2.定义请求的唯一标识
        String url = "http://127.0.0.1:8082/gril/springboot/postDemo?userName=张三";
        //3,定义请求对象
        HttpPost post = new HttpPost(url);
        //增加请求Header
        post.setHeader("HeaderName", "HedaerValue");
        post.setHeader("charset", "UTF-8");
        try {
            //增加具体有效的内容
            post.setEntity(new StringEntity("post request body", "utf-8"));
            //4，发送请求消息
            CloseableHttpResponse response = httpClient.execute(post);
            //获取响应的状态
            logger.info("========响应状态============" + response.getStatusLine().toString().split(" ")[1]);
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                logger.info("========响应Header=name============" + header.getName());
                logger.info("========响应Header=value===========" + header.getValue());
            }
            HttpEntity httpEntity = response.getEntity();
            String body2 = EntityUtils.toString(httpEntity);
            /**
             * 上面和下面的内容只能选一个，不能两个都同时存在
             */
//            String body1 = IOUtils.toString(httpEntity.getContent(),"utf-8");
//            logger.info("========响应内容=1==========="+ body1);
            logger.info("========响应内容=body2===========" + body2);
            logger.info("========响应内容=编码格式===========" + httpEntity.getContentEncoding());
            //5,关闭请求
            httpClient.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get请求
     * @param request
     * @return
     */
    public HttpClientResponse doGet(HttpClientRequest request){
        HttpClientResponse httpClientResponse = new HttpClientResponse();
        //1，初始、创建http请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //2.定义请求的唯一标识
//        String url = "http://127.0.0.1:8082/gril/springboot/hello";
        //3,定义请求对象
        HttpGet httpGet = new HttpGet(request.getUrl());
        //4，发送请求消息
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //获取响应的状态
            logger.info("========响应状态============" + response.getStatusLine().toString().split(" ")[1]);
            httpClientResponse.setStatusCode(response.getStatusLine().toString().split(" ")[1]);
            Map<String,String> responseHeader = new HashMap<String,String>();
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                logger.info("========响应Header=name============" + header.getName());
                logger.info("========响应Header=value===========" + header.getValue());
                responseHeader.put(header.getName(),header.getValue());
            }
            httpClientResponse.setHeaders(responseHeader);
            HttpEntity httpEntity = response.getEntity();
            String body1 = IOUtils.toString(httpEntity.getContent(), "utf-8");
            httpClientResponse.setBody(body1);
            logger.info("========响应内容=body1===========" + body1);
            //5,关闭请求
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpClientResponse;
    }

    /**
     * Post请求
     * @param request
     * @return
     */
    public HttpClientResponse doPost(HttpClientRequest request) {
        HttpClientResponse httpClientResponse = new HttpClientResponse();
        //1，初始、创建http请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //2.定义请求的唯一标识
//        String url = "http://127.0.0.1:8082/gril/springboot/postDemo?userName=张三";
        String url = request.getUrl();

        //3,定义请求对象
        HttpPost post = new HttpPost(url);
        //增加请求Header
//        post.setHeader("HeaderName", "HedaerValue");
//        post.setHeader("charset", "UTF-8");
        Map<String, String> reqHeadlers = request.getHeaders();
        for (String key : reqHeadlers.keySet()) {
            post.setHeader(key, reqHeadlers.get(key));
        }

        try {
            //增加body的内容
            post.setEntity(new StringEntity(request.getBody()));
            //4，发送请求消息
            CloseableHttpResponse response = httpClient.execute(post);
            //获取响应的状态
            logger.info("========响应状态============" + response.getStatusLine().toString().split(" ")[1]);
            String statusCode = response.getStatusLine().toString().split(" ")[1];
            httpClientResponse.setStatusCode(statusCode);
            //响应Header
            Map<String, String> responseHeaders = new HashMap<String, String>();
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                logger.info("========响应Header=name============" + header.getName());
                logger.info("========响应Header=value===========" + header.getValue());
                responseHeaders.put(header.getName(), header.getValue());
            }
            httpClientResponse.setHeaders(responseHeaders);
            //响应body
            HttpEntity httpEntity = response.getEntity();
            String body2 = EntityUtils.toString(httpEntity);
            httpClientResponse.setBody(body2);
            /**
             * 上面和下面的内容只能选一个，不能两个都同时存在
             */
//            String body1 = IOUtils.toString(httpEntity.getContent(),"utf-8");
//            logger.info("========响应内容=1==========="+ body1);
            logger.info("========响应内容=body2===========" + body2);
            logger.info("========响应内容=编码格式===========" + httpEntity.getContentEncoding());
            //5,关闭请求
            httpClient.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpClientResponse;
    }
}
