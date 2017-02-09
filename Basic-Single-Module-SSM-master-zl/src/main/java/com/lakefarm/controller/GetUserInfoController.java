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
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/lakeFarm")
public class GetUserInfoController {
    private static Logger log = Logger.getLogger(GetUserInfoController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value="/GetUserInfo.from", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getUser(HttpServletRequest request,HttpServletResponse response) {
        log.info("获取用户信息-------");
        try {
            Cookie[] cookies = request.getCookies();
            User user=new User();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().trim().equals("u_id")) {
                        user.setU_id(c.getValue().trim());//对u_id进行赋值
                    }
                }
                if("".equals(user.getU_id())){
                    return new String("102");//TODO COOKIES失效
                }
                else {
                    //建立映射
                    User user1=userService.getUserById(user.getU_id());
                    try {
                        //返回字符串
                        log.info("往前台发送！");
                        return new String("u_name:"+user1.getU_name()+"#u_money:"+user1.getU_money()+"#u_diamond:"+user1.getU_diamond()+"#u_type:"+user1.getU_type()+"#u_icon:"+user1.getU_icon()+"");//返回user json对象
                    }
                    catch (Exception e){
                        log.info("查询失败",e);
                        return new String("0");
                    }

                }
            }
            else {
                return new String("101");//TODO 不存在cookie重新登陆
            }
        } catch (Exception e) {
            log.error("异常错误位置----",e);
            return new String("100"); //TODO 获取用户信息失败
        }
    }

}
