package com.lakefarm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lakefarm.pojo.Tfarmtools;
import com.lakefarm.pojo.TfarmtoolsVo;
import com.lakefarm.service.TFarmtoolsService;
import com.lakefarm.utils.ResponseUtil;


@Controller
@RequestMapping("/shop/farmshop")
public class FarmtoolsController {
	
	@Autowired
	private TFarmtoolsService farmtoolsService;
	//���ӻ������ũ�ߵķ�����
	@RequestMapping(value = "addTfarmtools", method = RequestMethod.GET)  
	public String addTfarmtools(Tfarmtools tfarmtools,HttpServletResponse response) throws Exception{
		int resultnum=0;
		//����û�(add)
		if(tfarmtools.getNj_id()==null){
		 resultnum=farmtoolsService.addFarmtools(tfarmtools);
		}else{//����(update)
		 resultnum=farmtoolsService.updateFarmtools(tfarmtools);
		}
		
		JSONObject result=new JSONObject();//back
		//
		if(resultnum>1){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
   //ɾ���û��ķ�����
	/**
	 * ����˵����ɾ���û�
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletebyid")
	public String deleteTfarmtoolsbyId(@RequestParam(value="ids") String ids,HttpServletResponse response) throws Exception{
		int resultTotal=0;
		String[] idsStr=ids.split(",");//�������
		//����ɾ��
		for(String id:idsStr){
			farmtoolsService.deletebyId(Integer.parseInt(id));
			resultTotal++;
		}
		JSONObject result=new JSONObject();
		
		if(resultTotal>0){//ִ�гɹ�
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	//根据农具名查找
	@RequestMapping("/findByIdorName")
	public String findByIdorName(@ModelAttribute TfarmtoolsVo tfarmtoolsVo){
		List<Tfarmtools> list=farmtoolsService.findByidorName(tfarmtoolsVo);
		ModelAndView model=new ModelAndView();
		model.addObject("listfarmtools", list);
		return null;
		
	}
	
	//根据农具的id查找单价
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="njid") String njid,HttpServletResponse response)throws Exception{
		Tfarmtools tfarmtool=farmtoolsService.findById(njid);
		JSONObject result=new JSONObject();
		result.put("price",tfarmtool.getNj_price());
		result.put("name",tfarmtool.getNj_name());
		ResponseUtil.write(response, result);
		return null;
	}
	
//	//分页加载农具
//	@RequestMapping("")
//	public List<Tfarmtools> getFarmToolByPage()throws Exception{
//		
//		return null;
//	}
	
	//第一次加载显示农具
	@RequestMapping("/selectfarmtoolsByPage")
	public List<Tfarmtools> selectfarmtoolsByPage(String pageNow,HttpServletResponse response,HttpServletRequest request)throws Exception{
		List<Tfarmtools> listFarmtool = null;

		int pageNo = 1;
		//String pageno=request.getParameter("pageNos");
		if(pageNow != null){
		pageNo=Integer.parseInt(pageNow);
		}
		listFarmtool=farmtoolsService.selectfarmtoolsByPage(String.valueOf(pageNo));
//		request.setAttribute("recordCount", farmtoolsService.getTotal());
//		request.setAttribute("listss", listFarmtool);
//		request.setAttribute("pageNos", pageNo);
		
		JSONObject result=new JSONObject();
		for(int i=0;i<listFarmtool.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id",listFarmtool.get(i).getNj_id());
			map.put("name",listFarmtool.get(i).getNj_name());
			map.put("price",listFarmtool.get(i).getNj_price());
			map.put("description",listFarmtool.get(i).getNj_description());
			if(i==0){
				result.put("a",map);
			}
			if(i==1){
				result.put("b",map);
			}
			if(i==2){
				result.put("c",map);			
			}
			if(i==3){
				result.put("d",map);
			}
			if(i==4){
				result.put("e",map);
			}
			if(i==5){
				result.put("f",map);
			}
			if(i==6){
				result.put("g",map);
			}
			if(i==7){
				result.put("h",map);			
			}
			if(i==8){
				result.put("i",map);
			}

		}
		result.put("count",listFarmtool.size());
		ResponseUtil.write(response, result);
		return null;
	}

}
