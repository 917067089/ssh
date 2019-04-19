package main.com.imooc.utils;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;



public class MailUtil {
    Logger logger = Logger.getLogger(this.getClass());
    private static final String HOST = MailConfig.host;
    private static final Integer PORT = MailConfig.port;
    private static final String USERNAME = MailConfig.userName;
    private static final String PASSWORD = MailConfig.passWord;
    private static final String emailForm = MailConfig.emailForm;
    private static final String timeout = MailConfig.timeout;
    private static final String personal = MailConfig.personal;

    private static JavaMailSenderImpl mailSender = createMailSender();
    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", timeout);
        p.setProperty("mail.smtp.auth", "true");
        sender.setJavaMailProperties(p);
        return sender;
    }
    /**
     * 发送邮件
     *
     * @param to 接受人
     * @param subject 主题
     * @param context 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public static void sendMail(String to, String subject, String context) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(emailForm, personal);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(context, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送邮件 带附加的压缩包
     *
     * @param to 接受人
     * @param subject 主题
     * @param context 发送内容
     * @param filePaths 压缩包路径
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public static void sendMail(String to, String subject, String context,String [] filePaths) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(emailForm, personal);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(context, true);
            for(String filePath : filePaths){
                FileSystemResource fsr = new FileSystemResource(new File(filePath));
                String fileName = fsr.getFilename();
                messageHelper.addAttachment(fileName,fsr);
            }
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送邮件 带附加的压缩包
     *
     * @param to 接受人
     * @param subject 主题
     * @param context 发送内容
     * @param map 压缩包路径
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public static void sendMail(String to, String subject, String context,Map map) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(emailForm, personal);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(context, true);
            Iterator iterator =  map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                FileSystemResource fsr = new FileSystemResource(new File((String) entry.getValue()));
                messageHelper.addInline((String) entry.getKey(),fsr);
            }
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件带普通的内容
     */
    @Test
    public void testSendMailHtml () {
        String context="第一次java开发的邮件";
        String contexthtml="<html><body><h1>第一次java开发的邮件</h1></body></html>";
        logger.info("=====开时发送短信=====");
        try {
            sendMail("917067089@qq.com","第一次html邮件",context);
            logger.info("=====发送短信成功=====");
        } catch (Exception e) {
            logger.error("=====发送短信失败："+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 测试邮件 带附件的压缩包，图片
     */
    @Test
    public void testSendMailFile () {
        String filePath1 ="C:\\Users\\Administrator\\Desktop\\java\\springbootfraeemarker.zip";
        String filePath2 ="C:\\Users\\Administrator\\Desktop\\java\\wincmd操作命令.txt";
        String filePath3 ="C:\\Users\\Administrator\\Desktop\\java\\login.jpg";
        String filePath4 ="C:\\Users\\Administrator\\Desktop\\java\\datasource.jpg";
        String [] filePaths ={filePath1,filePath2,filePath3,filePath4};
        String context="第一次java开发带附件的邮件";
        String contexthtml="<html><body><h1>第一次java开发的邮件</h1></body></html>";
        logger.info("=====开时发送短信=====");
        try {
            sendMail("917067089@qq.com","第一次发送带附件的邮件",context,filePaths);
            logger.info("=====发送短信成功=====");
        } catch (Exception e) {
            logger.error("=====发送短信失败："+e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * 测试邮件 将图片显示到邮件中间的
     */
    @Test
    public void testSendMailImg () {
        String filePath3 ="C:\\Users\\Administrator\\Desktop\\java\\login.jpg";
        String rcsId="neo001";
        Map map = new HashMap();
        map.put(rcsId,filePath3);
        String filePath4 ="C:\\Users\\Administrator\\Desktop\\java\\datasource.jpg";
        rcsId="neo002";
        map.put(rcsId,filePath4);
        String img = "";
        Iterator iterator =  map.entrySet().iterator();
       while (iterator.hasNext()){
           Map.Entry entry = (Map.Entry) iterator.next();
           img += "<img src='cid:"+entry.getKey()+"'/>";
       }
        String contexthtml="<html><body>"+img+"</body></html>";
        logger.info("=====开时发送短信=====");
        try {
            sendMail("917067089@qq.com","第一次发送邮件里面直接显示图片的邮件",contexthtml,map);
            logger.info("=====发送短信成功=====");
        } catch (Exception e) {
            logger.error("=====发送短信失败："+e.getMessage());
            e.printStackTrace();
        }
    }
}
