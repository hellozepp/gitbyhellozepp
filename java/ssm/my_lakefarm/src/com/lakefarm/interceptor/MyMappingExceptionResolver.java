package com.lakefarm.interceptor;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyMappingExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest req,
                                         HttpServletResponse res, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);
        //TODO 根据不同错误转向不同页面
        return new ModelAndView("error", model);
    }

}
