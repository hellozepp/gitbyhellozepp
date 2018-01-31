package com.lakefarm.service;

import com.lakefarm.pojo.PersonFarmTools;

import java.util.List;

/**
 * Created by cxd on 2017/2/12.
 */
public interface PersonFarmToolsService {
    public List<PersonFarmTools> selectall();

    public long getTotal();

    public int addFarmtools(PersonFarmTools personFarmTools);

    public int deletebyId(Integer u_id,Integer nj_id);

    public int updateFarmtools(PersonFarmTools personFarmTools);

    public List<PersonFarmTools> findByU_Id(String u_id);

    public List<PersonFarmTools> selectfarmtoolsByPage(Integer start,Integer size);
}
