package org.controller3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	@ExceptionHandler
	public String execute(HttpServletRequest request, Exception ex){
		request.setAttribute("ex", ex);
		//TODO 可根据异常类型不同返回不同视图名
		return "error";
	}
}