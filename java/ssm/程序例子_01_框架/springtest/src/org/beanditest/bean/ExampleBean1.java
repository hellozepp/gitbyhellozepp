package org.beanditest.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class ExampleBean1 {

	public ExampleBean1(){
		System.out.println("实例化ExampleBean");
	}

	public void execute(){
		System.out.println("执行ExampleBean处理");
	}

	@PostConstruct
	public void init(){
		System.out.println("初始化ExampleBean对象");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("销毁ExampleBean对象");
	}
}