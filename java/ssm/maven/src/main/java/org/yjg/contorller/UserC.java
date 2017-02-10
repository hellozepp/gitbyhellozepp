package org.yjg.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yjg.bean.Result;
import org.yjg.bean.Userbean;
import org.yjg.service.IUserService;
import org.yjg.util.CommonConst;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

/**
 * Created by hadoop on 16-9-10.
 */
@Controller//
@RequestMapping("/user")///user自动家在该方法
public class UserC {
    @Resource//根据类名匹配
    private IUserService userService;
//     @Autowired(required = true)//找不到匹配的依赖会报错//默认True不报错
//    private IUserService service;

    @RequestMapping(value = "/sigIn" ,method = RequestMethod.POST)//定义请求的方法
    public Result register (@RequestBody String body){
//        userService.addNewUser(new Userbean());
        System.out.println("sigIn..........");

        System.out.println("register 实现！");
        Result result = new Result();
        try {
            Userbean userbean = JSON.parseObject(body,Userbean.class);
            String res =userService.add(userbean);
            if (res.equals(CommonConst.ONE)){
                result.setStatus(CommonConst.ONE_SHORT);
            }else if(res.equals("0")) {
                result.setStatus((short)0);
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String sigIn (@RequestBody String body){
        this.userService.add(new Userbean());
        System.out.println("login..........");
        return "/login.html";
    }


}
