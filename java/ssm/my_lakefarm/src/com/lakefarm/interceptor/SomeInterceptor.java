package com.lakefarm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeInterceptor implements HandlerInterceptor {


	public void afterCompletion(HttpServletRequest arg0,
								HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("请求处理完成后调用");
	}


	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
						   Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("处理器执行后调用");
	}


	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
							 Object arg2) throws Exception {
		System.out.println("处理器执行前调用");
		return true;
	}

}
