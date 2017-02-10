package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/findUser",method = RequestMethod.POST)
	public String getUser(){	
		return "findUser";
	}
	@RequestMapping("/")
	public String getIndex(){	
		return "index";
	}

}
