package com.lakefarm.mapper;

import com.lakefarm.pojo.PersonGrowplants;
import com.lakefarm.pojo.PersonGrowplantsExample;
import com.lakefarm.pojo.PersonGrowplantsKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonGrowplantsMapper {
    int countByExample(PersonGrowplantsExample example);

    int deleteByExample(PersonGrowplantsExample example);

    int deleteByPrimaryKey(PersonGrowplantsKey key);

    int insert(PersonGrowplants record);

    int insertSelective(PersonGrowplants record);

    List<PersonGrowplants> selectByExample(PersonGrowplantsExample example);

    PersonGrowplants selectByPrimaryKey(PersonGrowplantsKey key);

    int updateByExampleSelective(@Param("record") PersonGrowplants record, @Param("example") PersonGrowplantsExample example);

    int updateByExample(@Param("record") PersonGrowplants record, @Param("example") PersonGrowplantsExample example);

    int updateByPrimaryKeySelective(PersonGrowplants record);

    int updateByPrimaryKey(PersonGrowplants record);
}