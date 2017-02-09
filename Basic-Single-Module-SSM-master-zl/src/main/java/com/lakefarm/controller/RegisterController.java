package com.lakefarm.controller;

import com.lakefarm.pojo.User;
import com.lakefarm.mapper.UserMapper;
import com.lakefarm.service.UserService;
import com.lakefarm.utils.GetRandom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Reader;

/**
 * Created by andilyliao on 17-1-6.
 */
@Controller
@RequestMapping("/lakeFarm")
public class RegisterController {
    private static Logger log = Logger.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value="/register.from", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getUser(HttpServletRequest request,HttpServletResponse response) {
        log.info("register.....");
        //获取前台的信息  用户名  密码  手机号  身份证号 出生年月  所属区域 用户类型
        String userinfo= "";
        try {
            userinfo = new String(request.getParameter("user").trim().split("\\{")[1].getBytes("iso8859-1"),"UTF-8");
        } catch (Exception e) {
            log.error("数据接受异常---",e);
            return "101";//TODO 数据接受异常
        }
        //处理前台字符
        String username=userinfo.split("@")[0].trim();
        String password=userinfo.split("@")[1].trim();
        String phone=userinfo.split("@")[2].trim();
        String u_type=userinfo.split("@")[4].trim();
        String idCard=userinfo.split("@")[3].trim();
        String birthday=userinfo.split("@")[7].split("}")[0].trim();
        String area=userinfo.split("@")[6].trim();
        String description=userinfo.split("@")[5].trim();
        //打印前台信息
        log.info(username + "  " + password + "  " + idCard+"  "+phone+"  "+birthday+"  "+area+"  "+u_type+" "+description);
        User user = new User();
        user.setU_name(username);
        user.setU_pwd(password);
        user.setU_type(u_type);
        user.setU_phone(phone);
        user.setU_description(description);
        user.setU_IdCard(idCard);
        user.setU_birthdate(birthday);
        user.setU_area(area);
        user.setU_id(GetRandom.getUserId());
        //默认属性
        user.setU_diamond(1000);
        user.setU_money(1000);
        user.setU_vitality(100);
        user.setU_grade(1);

        //进行数据库添加处理
        try {
            int result=userService.addUser(user);
            log.info("注册成功！");
            return "1";//TODO 注册成功！

        } catch (Exception e) {
            log.error("异常信息位置---",e);
            return "100";// TODO 数据查找异常
        }

    }

}
