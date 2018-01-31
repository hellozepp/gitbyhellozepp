package com.lakefarm.service.Impl;

import com.lakefarm.mapper.DrugMapper;
import com.lakefarm.mapper.DrugMapperCustom;
import com.lakefarm.pojo.Drug;
import com.lakefarm.pojo.DrugQueryVo;
import com.lakefarm.pojo.DrugVo;
import com.lakefarm.service.DrugShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by docker on 2017/2/21.
 */
public class DrugShopServiceImpl implements DrugShopService {
    static Logger log = Logger.getLogger(BuyEmployeeServiceImpl.class.getName());
//  @Autowired
//  private DrugMapperCustom drugMapperCustom;
@Autowired
private ApplicationContext applicationContext;

    @Override
    public List<Drug> selectDrugList(Integer startNum,Integer cellCount) throws Exception {
     DrugMapperCustom drugMapperCustom = (DrugMapperCustom) applicationContext.getBean("drugMapperCustom");

     DrugQueryVo drugQueryVo =new DrugQueryVo();
        drugQueryVo.setStartNum(startNum);
        drugQueryVo.setCellCount(cellCount);
        return  drugMapperCustom.selectDrugList(drugQueryVo);
     }


    @Override
    public Integer selectDrugCount() throws Exception {
        DrugMapperCustom drugMapperCustom = (DrugMapperCustom) applicationContext.getBean("drugMapperCustom");
        return  drugMapperCustom.selectDrugCount();
    }


    @Override
    public DrugVo selectDrugInfo(Integer drugId) throws Exception {
        return null;
    }

    @Override
    public void updateDrugYpcount(Integer YpcountChange) throws Exception {

    }

    @Override
    public void insertDrugInfo(Drug drug) throws Exception {

    }

    @Override
    public void updateUserMoney(Integer uMoneyChange) throws Exception {

    }
}
