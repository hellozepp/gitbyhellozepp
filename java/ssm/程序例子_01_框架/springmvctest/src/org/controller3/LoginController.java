package org.controller3;

import org.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController extends BaseController{

	@RequestMapping("/toLogin.from")
	public String toLogin(){
		return "form";
	}

	@RequestMapping("/login1.from")
	public String checkLogin1(HttpServletRequest req){
		System.out.println("---方法一---");
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		return "ok";
	}

	@RequestMapping("/login2.from")
	public String checkLogin2(
			@RequestParam("username")String name,
			@RequestParam("password")String password){
		System.out.println("---方法二---");
		System.out.println(name);
		System.out.println(password);
		return "ok";
	}

	@RequestMapping("/login3.from")
	public String checkLogin3(User user){
		System.out.println("---方法三---");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return "ok";
	}

	@RequestMapping("/login4.from")
	public ModelAndView checkLogin4(HttpServletRequest req){
		System.out.println("---方法四---");
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", name);
		return new ModelAndView("ok",data);
	}

	@RequestMapping("/login5.from")
	public String checkLogin5(
			@RequestParam("username")String name,
			@RequestParam("password")String password,
			ModelMap model){
		System.out.println("---方法五---");
		System.out.println(name);
		System.out.println(password);
		model.addAttribute("user", name);
		if("scott".equals(name) && "1234".equals(password)){
			return "ok";
		}
		return "redirect:toLogin.from";
	}

	@RequestMapping("/login6.from")
	public String checkLogin6(@ModelAttribute("user") User user){
		System.out.println("---方法六---");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if("scott".equals(user.getUsername()) && "1234".equals(user.getPassword())){
			return "ok";
		}
		return "redirect:toLogin.from";
	}

	@ModelAttribute("user")
	public User getUser(){//避免HttpSessionRequiredException Session attribute ‘user’ required异常
		return new User();
	}

}