package com.lakefarm.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lakefarm.service.TFarmtoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakefarm.pojo.Tfarmtools;
import com.lakefarm.pojo.TfarmtoolsVo;
import com.lakefarm.mapper.TFarmtoolsMapper;
import com.lakefarm.utils.Page;


@Service
public class TFarmtoolsServiceImp implements TFarmtoolsService {
	
	 @Autowired
     private TFarmtoolsMapper farmtoolsmapper;
	 
	public List<Tfarmtools> selectall() {
		// TODO Auto-generated method stub
		return farmtoolsmapper.selectall();
	}

	public long getTotal() {
		// TODO Auto-generated method stub
		return farmtoolsmapper.getTotal();
	}

	public int addFarmtools(Tfarmtools tfarmtools) {
		return farmtoolsmapper.addFarmtools(tfarmtools);
		
		
	}

	public int deletebyId(Integer nj_id) {
		return farmtoolsmapper.deletebyId(nj_id);
		
	}

	public int updateFarmtools(Tfarmtools tfarmtools) {
		
		return farmtoolsmapper.updateFarmtools(tfarmtools);
		
	}
	public List<Tfarmtools> findByidorName(TfarmtoolsVo tfarmtoolVo) {
		// TODO Auto-generated method stub
		return farmtoolsmapper.findByidorName(tfarmtoolVo);
	}
	
	public Tfarmtools findById(String njid){
		return farmtoolsmapper.findById(njid);
	}

	//初始化显示农具店数据  pageNow当前页数
	public List<Tfarmtools> selectfarmtoolsByPage(String pageNow) {
		  
		    Page page = null;  
		  
		    List<Tfarmtools> tfarmtoolsbypage = new ArrayList<Tfarmtools>();  
		  
		    int totalCount = (int) farmtoolsmapper.getTotal();  //总记录数
		  
		    int size=0;//一页显示多少条数据
		    if(totalCount>9 || totalCount==9){
		    	size=9;
		    }else{
		    	size=totalCount;
		    }
		    
		   // int pagestart=(Integer.parseInt(pageNow)-1)*size;//从哪里开始

		    //初始化第一页
		    if (pageNow != null) {  
		        page = new Page(Integer.parseInt(pageNow),size);  
		        tfarmtoolsbypage = this.farmtoolsmapper.selectfarmtoolsByPage(page.getStart(),page.getPageSize());  
		    } 
		    return tfarmtoolsbypage;
	}

}
