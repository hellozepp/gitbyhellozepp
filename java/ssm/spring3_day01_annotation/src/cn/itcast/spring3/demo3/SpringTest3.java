package cn.itcast.spring3.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest3 {

	@Test
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext2.xml");
		CustomerService customerService = (CustomerService) applicationContext
				.getBean("customerService");
		System.out.println(customerService);
	}
}
