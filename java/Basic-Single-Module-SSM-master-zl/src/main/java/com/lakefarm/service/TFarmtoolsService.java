package com.lakefarm.service;

import java.util.List;

import com.lakefarm.pojo.Tfarmtools;
import com.lakefarm.pojo.TfarmtoolsVo;

/**
 * (ũ�ߵ�seervice��)
 * @author pjw
 */

public interface TFarmtoolsService {
	
public List<Tfarmtools> selectall();
	
	public long getTotal();
	
	public int addFarmtools(Tfarmtools tfarmtools);
	
	public int deletebyId(Integer nj_id);
	
	public int updateFarmtools(Tfarmtools tfarmtools);
	
	public List<Tfarmtools> findByidorName(TfarmtoolsVo tfarmtoolVo);
	
	/** 
     * 分页显示
     * @param request 
     * @param model 
     * @param loginUserId 
     */  
    public List<Tfarmtools> selectfarmtoolsByPage(String pageNow);  
	
    public Tfarmtools findById(String njid);

}
