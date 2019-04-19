package main.com.imooc.utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public class HttpsRequestDemo {
    // 阿里短信地址
    private String targetURL = "https://aliyun.chanyoo.net/sendsms";
    // appcode
    private String Authorization = "APPCODE " +"ddf3f202b3a647179ab232c02a3bbf8e";


    /**
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpsRequestDemo requestDemo = new HttpsRequestDemo();

        // 手机号
        String mobile = "18070159378";

        // 短信内容
        String content = "您的手机号：18070159378，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】";
        try {
            String result = requestDemo.sentHttpPostRequest(mobile,content);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String sentHttpPostRequest(String mobile,String content) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();

        // 设置超时时间
        int timeout = 60000;
        HttpConnectionParams.setSoTimeout(httpclient.getParams(), timeout);

        // 注意：必须以post方式发送请求
        HttpPost httppost = new HttpPost(targetURL);

        // 设置请求参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        // applyCode
        params.add(new BasicNameValuePair("Authorization", Authorization));
        // 手机号
        params.add(new BasicNameValuePair("mobile", mobile));
        // 短信内容
        params.add(new BasicNameValuePair("content", content));

        // 注意：编码必须是UTF-8
        HttpEntity request = new UrlEncodedFormEntity(params, "UTF-8");
        httppost.setEntity(request);

        // 返回内容为json，请使用json解析工具对返回内容进行解析
        HttpResponse httpResponse = httpclient.execute(httppost);
        HttpEntity entity = httpResponse.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity);
        }

        return result;
    }
}
