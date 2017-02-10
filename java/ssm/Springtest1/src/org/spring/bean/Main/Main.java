package org.spring.bean.Main;

import org.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-4.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("resource/ApplicationContext.xml");
        Person p =applicationContext.getBean("person",Person.class);
        p .execute();
        applicationContext.close();

    }
}
