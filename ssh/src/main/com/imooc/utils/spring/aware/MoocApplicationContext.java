package main.com.imooc.utils.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MoocApplicationContext implements ApplicationContextAware  {
    //如何在类中使用spring的配置文件
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println("MoocApplicationContext : " + applicationContext.getBean("moocApplicationContext").hashCode());
    }

}