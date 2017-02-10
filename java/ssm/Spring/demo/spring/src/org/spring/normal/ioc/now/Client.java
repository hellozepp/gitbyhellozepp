package org.spring.normal.ioc.now;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:46
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_ioc.xml");

        UserService service = context.getBean("userService", UserServiceImp.class);
        service.addNewUser("leoashin", "123");
    }
}
