package org.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day01")
public class HelloController{

	@RequestMapping("/hello.from")
	public String execute() throws Exception {
		return "hello";
	}
 
}
