package com.lakefarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lakefarm.pojo.Tfarmtools;
import com.lakefarm.pojo.TfarmtoolsVo;

/**
 * 
 * @author pjw
 *  ũ�ߵ��mapper�ӿ�
 */
public interface TFarmtoolsMapper {
	
	public List<Tfarmtools> selectall();
	
	public long getTotal();
	
	public int addFarmtools(Tfarmtools tfarmtools);
	
	public int deletebyId(Integer nj_id);
	
	public int updateFarmtools(Tfarmtools tfarmtools);
	
	public List<Tfarmtools> findByidorName(TfarmtoolsVo tfarmtoolsVo);
	
	public Tfarmtools findById(@Param(value = "njid") String njid);
	
	public List<Tfarmtools> selectfarmtoolsByPage(@Param(value = "start") Integer start, @Param(value = "size") Integer size);

}
