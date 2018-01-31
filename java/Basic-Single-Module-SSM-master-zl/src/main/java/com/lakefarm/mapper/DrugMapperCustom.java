package com.lakefarm.mapper;

import com.lakefarm.pojo.Drug;
import com.lakefarm.pojo.DrugQueryVo;

import java.util.List;

/**
 * Created by docker on 2017/2/21.
 */
public interface DrugMapperCustom {
    public Integer selectDrugCount();
    public List<Drug> selectDrugList(DrugQueryVo drugQueryVo);

}
