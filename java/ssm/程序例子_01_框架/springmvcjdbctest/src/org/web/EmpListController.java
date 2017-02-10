package org.web;

import java.util.List;

import org.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dao.EmpDAO;
import org.entity.Emp;

@Controller
public class EmpListController {
	private EmpService service;
	@Autowired
	public void setService(EmpService service) {
		this.service = service;
	}
	@RequestMapping("/emp/list.do")
	public String execute(Model model){
		List<Emp> list = service.findAll();
		model.addAttribute("emps", list);
		return "emp_list";
	}
}
