package main.com.imooc.utils.spring.autowiring;

public class AutoWiringService {
	
	private AutoWiringDAO autoWiringDAO;

//	public AutoWiringService(AutoWiringDAO autoWiringDAO) {
//		System.out.println("construcytor AutoWiringService");
//		this.autoWiringDAO = autoWiringDAO;
//	}

	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
		System.out.println("setAutoWiringDAO");
		this.autoWiringDAO = autoWiringDAO;
	}
	
	public void say(String word) {
		this.autoWiringDAO.say(word);
	}

}
