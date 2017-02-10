package cn.itcast.spring3.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 注解的方式:
public class SpringTest1 {

	@Test
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println(userService);
		
		UserService userService2 = (UserService) applicationContext.getBean("userService");
		System.out.println(userService2);
		
		applicationContext.close();
	}
}
