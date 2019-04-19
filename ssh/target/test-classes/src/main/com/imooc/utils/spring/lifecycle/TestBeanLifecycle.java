package main.com.imooc.utils.spring.lifecycle;

import main.com.imooc.utils.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifecycle extends UnitTestBase {
	
	public TestBeanLifecycle() {

//		super("classpath:spring-lifecycle.xml");
	}
	
	@Test
	public void test1() {
		super.getBean("beanLifeCycle");
	}
	
}
