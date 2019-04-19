package main.com.imooc.utils.spring.aware;

import main.com.imooc.utils.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {
    public TestAware() {
        super("classpath:applicationContext.xml");
    }

//	@Test
	public void testMoocApplicationContext() {
		System.out.println("testMoocApplicationContext : " + super.getBean("moocApplicationContext").hashCode());
	}
//    @Test
    public void textMoocBeanName() {
        System.out.println("textMoocBeanName : " + super.getBean("moocBeanName").hashCode());
    }
}
