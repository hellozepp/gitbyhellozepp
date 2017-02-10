package org.spring.ComponentTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-11.
 */
public class SpringTest2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("resource/SpringTest2.xml");
        UserService userService = (UserService) applicationContext.getBean("123");
//        userService.sayHello();//通过ioc注解的方式控制类的反转
        System.out.println(userService);
    }
}
