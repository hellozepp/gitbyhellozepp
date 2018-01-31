package com.lakefarm.controller;

import com.lakefarm.pojo.FarmTools;
import com.lakefarm.pojo.PersonFarmTools;
import com.lakefarm.pojo.User;
import com.lakefarm.service.FarmToolsService;
import com.lakefarm.service.PersonFarmToolsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cxd on 2017/2/12.
 */
@Controller
@RequestMapping("/lakeFarm")
public class GetFarmToolsController {
    private static Logger log = Logger.getLogger(GetUserInfoController.class);
    @Autowired
    private FarmToolsService farmToolsService;
    @Autowired
    private PersonFarmToolsService personFarmToolsService;
    @RequestMapping(value="/getFarmTools.from", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String getUser(HttpServletRequest request,HttpServletResponse response) {
        log.info("进行农具查询----" + "\n");
        String result="";
        try {
            Cookie[] cookies = request.getCookies();
            User user = new User();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().trim().equals("u_id")) {
                        user.setU_id(c.getValue().trim());//TODO 对u_id进行赋值
                    }
                }
                if ("".equals(user.getU_id())) {
                    return new String("101");//TODO COOKIES失效
                } else {
                    List<PersonFarmTools> personFarmToolsList=personFarmToolsService.findByU_Id(user.getU_id());
                    int personFarmToolsListSize=personFarmToolsList.size();
                    for (int i=0;i<personFarmToolsListSize;i++){
                        FarmTools farmTools=farmToolsService.findById(personFarmToolsList.get(i).getNj_id());
                        result+=""+farmTools.getNj_name().trim()+"#"+personFarmToolsList.get(i).getNj_count()+";";
                    }
                }
                log.info(result);
                return result;//TODO 查询成功！
            } else {
                return "101";//TODO COOKIE 失效
            }
        }
        catch (Exception e) {
            log.error("错误信息", e);
            return "100";//TODO 网络异常
        }
    }
}
