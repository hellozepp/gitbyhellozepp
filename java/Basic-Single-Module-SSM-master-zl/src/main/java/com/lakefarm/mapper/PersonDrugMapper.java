package com.lakefarm.mapper;

import com.lakefarm.pojo.PersonDrug;
import com.lakefarm.pojo.PersonDrugExample;
import com.lakefarm.pojo.PersonDrugKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDrugMapper {
    int countByExample(PersonDrugExample example);

    int deleteByExample(PersonDrugExample example);

    int deleteByPrimaryKey(PersonDrugKey key);

    int insert(PersonDrug record);

    int insertSelective(PersonDrug record);

    List<PersonDrug> selectByExample(PersonDrugExample example);

    PersonDrug selectByPrimaryKey(PersonDrugKey key);

    int updateByExampleSelective(@Param("record") PersonDrug record, @Param("example") PersonDrugExample example);

    int updateByExample(@Param("record") PersonDrug record, @Param("example") PersonDrugExample example);

    int updateByPrimaryKeySelective(PersonDrug record);

    int updateByPrimaryKey(PersonDrug record);
}