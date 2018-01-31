package com.lakefarm.mapper;

import com.lakefarm.pojo.GrowPlants;
import com.lakefarm.pojo.PersonGrowplants;
import com.lakefarm.pojo.ShopGrowplants;

/**
 * Created by docker on 2017/2/23.
 */
public interface GrowplantsMapperCustom {
    //grow_plants person_growplants shop_growplants
    //购买种子业务
    //1. 根据zzid查询zz信息
    //  (1)查询种子数量 shop_growplants
    public Integer selectGrowplantCount(Integer zzId);
    //  (2)查询种子信息 grow_plants
    public GrowPlants selectGrowplantInfo(Integer zzId);
    //  (3)查询背包该商品数量 person_growplants
    public Integer selectGrowplantsByZzId(Integer zzId);
    //2. 查询个人余额 userinfo
    //3. 购买种子
    //  (1)添加到背包 person_growplants
    public void insertGrowplants(PersonGrowplants personGrowplants);
    //  (2)根据购买量减少种子数量 shop_growplants
    public void updateGrowplants(ShopGrowplants shopGrowplants);
    //  (2)扣除金额 userinfo
}
