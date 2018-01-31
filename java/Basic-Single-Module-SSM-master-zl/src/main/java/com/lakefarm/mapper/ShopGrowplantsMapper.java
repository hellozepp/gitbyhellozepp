package com.lakefarm.mapper;

import com.lakefarm.pojo.ShopGrowplants;
import com.lakefarm.pojo.ShopGrowplantsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopGrowplantsMapper {
    int countByExample(ShopGrowplantsExample example);

    int deleteByExample(ShopGrowplantsExample example);

    int deleteByPrimaryKey(Integer zzId);

    int insert(ShopGrowplants record);

    int insertSelective(ShopGrowplants record);

    List<ShopGrowplants> selectByExample(ShopGrowplantsExample example);

    ShopGrowplants selectByPrimaryKey(Integer zzId);

    int updateByExampleSelective(@Param("record") ShopGrowplants record, @Param("example") ShopGrowplantsExample example);

    int updateByExample(@Param("record") ShopGrowplants record, @Param("example") ShopGrowplantsExample example);

    int updateByPrimaryKeySelective(ShopGrowplants record);

    int updateByPrimaryKey(ShopGrowplants record);
}