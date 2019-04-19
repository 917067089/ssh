package main.com.imooc.utils.spring.autowiring;

import main.com.imooc.utils.spring.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring extends UnitTestBase {
	
	public TestAutoWiring() {
//		super("classpath:applicationContext.xml");
	}

	/**
	 * �Զ�װ��
	 * ByTyep���Զ�װ�� ��bean��idû��ֱ�ӹ�ϵ��ByName�й�ϵ
	 */
	@Test
	public void testSay() {
		AutoWiringService service = super.getBean("autoWiringService");
		service.say(" this is a test");
	}

}
