package main.com.hnnd.stucommunity.business.controller;

import javax.servlet.http.HttpServletRequest;

import main.com.hnnd.stucommunity.business.service.TagService;
import main.com.hnnd.stucommunity.common.base.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {
	@Autowired
	TagService tagService;
	
	@RequestMapping("/saveTagRelation")
	@ResponseBody
	public ResultModel addTag(HttpServletRequest request){
		
		if(tagService.saveTagRelation(request).isFail()){
			return ResultModel.failModel();
		}
		
		return ResultModel.successModel();
	}
	
	
}
