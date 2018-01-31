package com.lakefarm.service.Impl;

import com.lakefarm.mapper.FarmToolsMapper;
import com.lakefarm.pojo.FarmTools;
import com.lakefarm.service.FarmToolsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cxd on 2017/2/12.
 */
@Service
public class FarmToolsServiceImp implements FarmToolsService {
    @Autowired
    private FarmToolsMapper farmToolsMapper;
    @Override
    public List<FarmTools> selectall() {
        return farmToolsMapper.selectall();
    }

    @Override
    public long getTotal() {
        return farmToolsMapper.getTotal();
    }

    @Override
    public int addFarmtools(FarmTools tfarmtools) {
        return farmToolsMapper.addFarmtools(tfarmtools);
    }

    @Override
    public int deletebyId(String nj_id) {
        return farmToolsMapper.deletebyId(nj_id);
    }

    @Override
    public int updateFarmtools(FarmTools tfarmtools) {
        return farmToolsMapper.updateFarmtools(tfarmtools);
    }

    @Override
    public FarmTools findById(@Param(value = "njid") String njid) {
        return farmToolsMapper.findById(njid);
    }

    @Override
    public List<FarmTools> selectfarmtoolsByPage(@Param(value = "start") Integer start, @Param(value = "size") Integer size) {
        return farmToolsMapper.selectfarmtoolsByPage(start,size);
    }
}
