package org.zl.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zl.service.UserService;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by hadoop on 16-9-12.
 */

public class UserServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取  WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
       WebApplicationContext applicationContext =WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//        没有直接用ApplicationContext对象，所以不会每次启动都加载资源
        System.out.println("调用了 WebApplicationContext 全局对象 实现aop编程。 每次加载服务器才会调用");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    doPost(request, response);
    }
}
