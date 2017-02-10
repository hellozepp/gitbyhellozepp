package org.yjg.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-24.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring-mvc.xml");
        Test1 test1 =applicationContext.getBean("test",Test1.class);
        test1.testService();
    }
}
