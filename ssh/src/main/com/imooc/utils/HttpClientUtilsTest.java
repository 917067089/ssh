package main.com.imooc.utils;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtilsTest {
    public static Logger logger = Logger.getLogger(HttpClientUtilsTest.class);


    @Test
    public void testMethod(){
        StrutsPrepareAndExecuteFilter filter = new StrutsPrepareAndExecuteFilter();

        HttpClientRequest httpClientRequest = new HttpClientRequest();
//        String userName="张三";
//        String url ="http://127.0.0.1:8082/gril/springboot/postDemo?userName="+userName;
        String url ="http://127.0.0.1:8082/gril/springboot/postDemo";
        Map <String,String> quesrParams = new HashMap<String, String>();
        quesrParams.put("userName","李四");
        String resultUrl =  HttpClientUtils.formatUrl(url,quesrParams);
        httpClientRequest.setUrl(resultUrl);

        Map<String, String> reqeustHeaders = new HashMap<String, String>();
        reqeustHeaders.put("Content-Type", "text/html;charset=UTF-8");
        httpClientRequest.setHeaders(reqeustHeaders);
        httpClientRequest.setBody("post body test String");
        HttpClientResponse httpClientResponse = HttpClientUtils.doPost(httpClientRequest);
        Assert.assertEquals("200",httpClientResponse.getStatusCode());

    }
    @Test
    public void formatUrlTest(){
        String url ="http://127.0.0.1:8082/gril/springboot/postDemo";
        Map <String,String> quesrParams = new HashMap<String, String>();
        quesrParams.put("userName","李四");
       String ResultUrl =  HttpClientUtils.formatUrl(url,quesrParams);
        logger.info(ResultUrl);

    }
}
