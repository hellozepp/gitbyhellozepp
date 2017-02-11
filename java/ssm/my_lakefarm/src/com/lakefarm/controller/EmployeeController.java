package com.lakefarm.controller;

import com.lakefarm.service.BuyEmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hadoop on 17-2-5.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    @Qualifier(value = "buyEmployeeService")
    private BuyEmployeeService buyEmployeeService;
    private static Logger log = Logger.getLogger(EmployeeController.class);
    @RequestMapping(value = "/queryEmployee.from",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
      String queryEmployee(HttpServletRequest request, HttpServletResponse response){
        try {
//            String u_id=request.getParameter("u_id").trim();
            String u_id = "2";
            String Stringe_id=request.getParameter("e_id").trim();
            try {
                int e_id = Integer.parseInt(Stringe_id);
                String notice =buyEmployeeService.BuyEmployee(u_id,e_id);
                return notice;
            } catch (NumberFormatException e) {
                log.error("e_id的类型转换错误！");
                return "用户匹配失败！";
            }
        }
        catch (Exception e){
            log.error("异常信息位置----",e);
            return new String("0");
        }
    }
}