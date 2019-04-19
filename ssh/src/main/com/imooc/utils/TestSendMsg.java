package main.com.imooc.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class TestSendMsg {
    public static void main(String[] args) {
        String host = "https://aliyun.chanyoo.net";
        String path = "/sendsms";
        String method = "GET";
        String appcode = "ddf3f202b3a647179ab232c02a3bbf8e";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("mobile", "19921951579");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        //querys.put("content", "您的手机号：13333333333，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");
        String messageText  = "您的手机号：19921951579，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】";
        String messageContent = String.format(messageText,formatter.format(new Date()));
        bodys.put("content", messageContent);

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, bodys);
//            System.out.println(response.toString());
            //获取response的body
           String responseStr  = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = (JSONObject)JSONObject.parse(responseStr);
            String result = jsonObject.getString("result");
            String errmsg = jsonObject.getString("errmsg");
            if (",0,".indexOf(","+result+",")>=0){
                System.out.println("以收到短信，结果为:"+errmsg);
            }else {
                System.out.println("没有收到短信，结果为:"+errmsg);
            }
        } catch (Exception e) {
            System.out.println("发送错误"+e.getMessage());
            e.printStackTrace();
        }
    }
}
