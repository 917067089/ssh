package main.com.imooc.utils.spring.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;


public class MoocResource implements ApplicationContextAware  {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void resource() throws IOException {
		Resource resource = applicationContext.getResource("applicationContext.xml");
//		Resource resource = applicationContext.getResource("file£ºD:\\gradle\\ssh\src\\applicationContext.xml");
//		Resource resource = applicationContext.getResource("url£ºhttps://www.imooc.com/video/3758");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}

}
