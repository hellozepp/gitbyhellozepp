package cn.itcast.spring3.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean(name="car")
	public Car showCar(){
		Car car = new Car();
		car.setName("长安");
		car.setPrice(40000d);
		return car;
	}
	
	@Bean(name="product")
	public Product initProduct(){
		Product product = new Product();
		product.setName("空调");
		product.setPrice(3000d);
		return product;
	}
}
