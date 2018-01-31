package com.lakefarm.service;

import com.lakefarm.pojo.GrowPlants;

/**
 * Created by docker on 2017/2/23.
 */
public interface GrowplantsShopService {
    public GrowPlants selectGrowplantInfo(Integer zzId) throws Exception;
    public Integer selectGrowplantCount(Integer zzId) throws  Exception;
    public Integer selectGrowplantsByZzId(Integer zzId) throws  Exception;
}
