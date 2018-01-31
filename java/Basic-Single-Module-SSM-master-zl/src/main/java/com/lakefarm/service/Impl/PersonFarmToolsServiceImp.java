package com.lakefarm.service.Impl;

import com.lakefarm.mapper.PersonFarmToolsMapper;
import com.lakefarm.pojo.PersonFarmTools;
import com.lakefarm.service.PersonFarmToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cxd on 2017/2/12.
 */
@Service
public class PersonFarmToolsServiceImp implements PersonFarmToolsService {
    @Autowired
    private PersonFarmToolsMapper personFarmToolsMapper;
    @Override
    public List<PersonFarmTools> selectall() {
        return personFarmToolsMapper.selectall();
    }

    @Override
    public long getTotal() {
        return personFarmToolsMapper.getTotal();
    }

    @Override
    public int addFarmtools(PersonFarmTools personFarmTools) {
        return personFarmToolsMapper.addFarmtools(personFarmTools);
    }

    @Override
    public int deletebyId(Integer u_id, Integer nj_id) {
        return personFarmToolsMapper.deletebyId(u_id,nj_id);
    }

    @Override
    public int updateFarmtools(PersonFarmTools personFarmTools) {
        return personFarmToolsMapper.updateFarmtools(personFarmTools);
    }

    @Override
    public List<PersonFarmTools> findByU_Id(String u_id) {
        return personFarmToolsMapper.findByU_Id(u_id);
    }

    @Override
    public List<PersonFarmTools> selectfarmtoolsByPage(Integer start, Integer size) {
        return personFarmToolsMapper.selectfarmtoolsByPage(start,size);
    }
}
