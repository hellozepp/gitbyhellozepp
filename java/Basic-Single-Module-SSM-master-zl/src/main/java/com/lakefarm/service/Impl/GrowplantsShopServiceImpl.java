package com.lakefarm.service.Impl;

import com.lakefarm.mapper.GrowplantsMapperCustom;
import com.lakefarm.pojo.GrowPlants;
import com.lakefarm.service.GrowplantsShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by docker on 2017/2/23.
 */
@Service
public class GrowplantsShopServiceImpl implements GrowplantsShopService {
    @Resource
    GrowplantsMapperCustom growplantsMapperCustom;
    @Override
    public GrowPlants selectGrowplantInfo(Integer zzId) throws Exception{
        return growplantsMapperCustom.selectGrowplantInfo(zzId);
    }

    @Override
    public Integer selectGrowplantCount(Integer zzId) throws Exception {
        return growplantsMapperCustom.selectGrowplantCount(zzId);
    }

    @Override
    public Integer selectGrowplantsByZzId(Integer zzId) throws Exception {
        return growplantsMapperCustom.selectGrowplantsByZzId(zzId);
    }
}
