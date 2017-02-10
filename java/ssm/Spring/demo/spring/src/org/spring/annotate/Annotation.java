package org.spring.annotate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午3:29
 */
public class Annotation {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_annotation.xml");

        Bean bean = applicationContext.getBean("bean", Bean.class);

        Bean bean1 = applicationContext.getBean("bean", Bean.class);

        System.out.println(bean == bean1);
    }
}
