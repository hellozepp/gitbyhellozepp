package cn.itcast.spring3.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintTest {
	
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		Car car = (Car) applicationContext.getBean("car");
		Product product = (Product) applicationContext.getBean("product");
		System.out.println(car);
		System.out.println(product);
	}
}
