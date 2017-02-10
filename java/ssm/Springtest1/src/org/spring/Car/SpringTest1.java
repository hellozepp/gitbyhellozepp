package org.spring.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-9.
 */
public class SpringTest1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "resource/ApplicationContext1.xml");
        PersonInfo personInfo = (PersonInfo) applicationContext.getBean("person");
        System.out.println(personInfo);
    }
}
