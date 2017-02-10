package org.spring.normal.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:09
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_demo2.xml");

//        LifeCycle lifeCycle = context.getBean("lifeCycle", LifeCycle.class);
//
//        LifeCycle lifeCycle1 = context.getBean("lifeCycle", LifeCycle.class);
//
//        System.out.println(lifeCycle == lifeCycle1);



    }
}
