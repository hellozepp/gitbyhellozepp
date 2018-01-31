package com.lakefarm.mapper;

import com.lakefarm.pojo.GrowPlants;
import com.lakefarm.pojo.GrowPlantsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrowPlantsMapper {
    int countByExample(GrowPlantsExample example);

    int deleteByExample(GrowPlantsExample example);

    int deleteByPrimaryKey(Integer zzId);

    int insert(GrowPlants record);

    int insertSelective(GrowPlants record);

    List<GrowPlants> selectByExample(GrowPlantsExample example);

    GrowPlants selectByPrimaryKey(Integer zzId);

    int updateByExampleSelective(@Param("record") GrowPlants record, @Param("example") GrowPlantsExample example);

    int updateByExample(@Param("record") GrowPlants record, @Param("example") GrowPlantsExample example);

    int updateByPrimaryKeySelective(GrowPlants record);

    int updateByPrimaryKey(GrowPlants record);
}