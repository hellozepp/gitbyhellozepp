package com.lakefarm.controller;

import com.lakefarm.pojo.User;
import com.lakefarm.mapper.UserMapper;
import com.lakefarm.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Reader;

/**
 * Created by andilyliao on 17-1-6.
 */
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
@Controller
@RequestMapping("/lakeFarm")
public class LoginController {
    private static Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value="/login.from", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object getUser(HttpServletRequest request,HttpServletResponse response) {
        try {
            log.info("登陆-----");
            String username=request.getParameter("username").trim();
            String password=request.getParameter("password").trim();
            log.info(username + "  " + password + "\n");
            User user = new User();
            user.setU_name(username);
            user.setU_pwd(password);
            //建立映射
            User user1=userService.login(user);
            try {
                user1.getU_name();
            }catch (Exception e){
                log.info("登陆失败！");
                return  new String("0");//TODO 用户名或者密码错误！
            }
            if ("null".equals(user1)||user1.equals("")||user1.equals(null)){
                log.info("登陆失败！");
                return  new String("0");//TODO 用户名或者密码错误！
            }
            else if (user.getU_name().trim().equals(user1.getU_name().trim())&&user.getU_pwd().trim().equals(user1.getU_pwd().trim()))
            {
                log.info("登陆成功！");
                Cookie info = new Cookie("u_id",String.valueOf(user1.getU_id()));
                info.setPath("/");
                info.setMaxAge(24*60*60);
                response.addCookie(info);
                return new String("1");//TODO 登陆成功！
            }
            else {
                log.info("登陆失败！");
                return  new String("0");//TODO 用户名或者密码错误！
            }

        } catch (Exception e) {
            log.error("异常信息位置----",e);
            return new String("100");
        }

    }

}
