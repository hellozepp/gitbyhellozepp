package org.spring.normal.kindsofinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午3:50
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_special.xml");

        MessageBean messageBean = context.getBean("messageBean", MessageBean.class);
    }
}
