package org.spring.normal.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午12:58
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc_demo3.xml");

        IEmpDao dao = context.getBean("EmpDao1", EmpDao.class);

        dao.add();
    }
}
