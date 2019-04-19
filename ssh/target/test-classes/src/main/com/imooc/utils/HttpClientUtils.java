package main.com.imooc.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtils {
    public static Logger logger =Logger.getLogger(HttpClientUtils.class);

    //1,建立连接
    private  CloseableHttpClient httpClient;

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }
    //初始化连接
    private void init(){
        //1，初始、创建http请求
        httpClient = HttpClientBuilder.create().build();
        logger.info("start init http connecion");
    }
    //关闭连接
    private void close(){
        try {
            httpClient.close();
            logger.info("close http connecion success");
        } catch (IOException e) {
            logger.error("close http connection failed"+e.getMessage()  );
            e.printStackTrace();
        }
    }
    private HttpClientResponse sendRequest(HttpRequestBase httpRequestBase, HttpClientRequest request){
        HttpClientResponse httpClientResponse = new HttpClientResponse();
        String encoding  = "ISO-8859-1";
        //3,定义请求对象
        //增加请求Header
        Map<String, String> reqHeadlers = request.getHeaders();
        for (String key : reqHeadlers.keySet()) {
            httpRequestBase.setHeader(key, reqHeadlers.get(key));
            if(key.toLowerCase().equals("content-type")){
                String contentType = reqHeadlers.get(key);
                if(reqHeadlers.get(key).split(";").length>=2){
                    encoding = contentType.split(";")[1].split("=")[1];
                }
            }
        }
        try {
            //增加body的内容
            if(httpRequestBase instanceof HttpEntityEnclosingRequestBase){
                ((HttpEntityEnclosingRequestBase)httpRequestBase).setEntity(new StringEntity(request.getBody(),encoding));
            }
            //4，发送请求消息
            CloseableHttpResponse response = httpClient.execute(httpRequestBase);
            //获取响应的状态
            String statusCode = response.getStatusLine().toString().split(" ")[1];
            httpClientResponse.setStatusCode(statusCode);
            //响应Header
            Map<String, String> responseHeaders = new HashMap<String, String>();
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
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
            logger.info("========响应内容=body2===========" + body2);
            this.close();
        } catch (UnsupportedEncodingException e) {
            logger.error("this encoding is not suppared"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return httpClientResponse;
    }
    public static String formatUrl(String url,Map<String,String> queryParams){
        // String url ="http://127.0.0.1:8082/gril/springboot/postDemo?userName="+userName;
        String result = "";
        String params = "";
        for(String key :queryParams.keySet()){
            params +=  key+"="+queryParams.get(key)+"&";
        }
        result +=(url+"?"+params.substring(0,params.length()-1));
        return result;
    }
    /**
     * Get请求
     * @param httpClientRequest
     * @return
     */
    public static HttpClientResponse doGet(HttpClientRequest httpClientRequest){
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.init();
        HttpGet httpGet = new HttpGet(httpClientRequest.getUrl());
        return httpClientUtils.sendRequest(httpGet,httpClientRequest);
    }

    /**
     * Post请求
     * @param httpClientRequest
     * @return
     */
    public static HttpClientResponse doPost(HttpClientRequest httpClientRequest){
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.init();
        HttpPost httpPost = new HttpPost(httpClientRequest.getUrl());
        return httpClientUtils.sendRequest(httpPost,httpClientRequest);
    }

    /**
     * Delete请求
     * @param httpClientRequest
     * @return
     */
    public static HttpClientResponse doDelete(HttpClientRequest httpClientRequest){
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.init();
        HttpDelete httpDelete = new HttpDelete(httpClientRequest.getUrl());
        return httpClientUtils.sendRequest(httpDelete,httpClientRequest);
    }

    /**
     * Put请求
     * @param httpClientRequest
     * @return
     */
    public static HttpClientResponse doPut(HttpClientRequest httpClientRequest){
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.init();
        HttpPut httpPut = new HttpPut(httpClientRequest.getUrl());
        return httpClientUtils.sendRequest(httpPut,httpClientRequest);
    }

}
