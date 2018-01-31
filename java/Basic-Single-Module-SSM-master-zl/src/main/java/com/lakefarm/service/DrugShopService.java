package com.lakefarm.service;
import com.lakefarm.mapper.DrugMapper;
import com.lakefarm.pojo.Drug;
import com.lakefarm.pojo.DrugVo;

import java.util.List;

/**
 * Created by docker on 2017/2/21.
 */
public interface DrugShopService {
//    -- 表关系：
//            --   药品商店

//-- 1
//--   （查询农药）
    public List<Drug> selectDrugList(Integer startNum,Integer cellCount) throws Exception;
//            -- userinfo drug person_drug

//  显示总页数
    public Integer selectDrugCount() throws Exception;
//
// -- 2 显示后继页内容
   //同上
//-- 3 点击后传送商品id
    public Drug selectDrugInfo(Integer drugId) throws Exception;
//-- ` 查询商品信息是否存在（商品不存在）

//-- ` 根据信息判断商品数量
//-- ` 判断余额
//-- 4 更新商品剩余数量
    public void updateDrugYpcount(Integer YpcountChange) throws Exception;
//-- 8 插入背包
    public void insertDrugInfo(Drug drug) throws Exception;
//-- 9 更新余额
    public void updateUserMoney(Integer uMoneyChange) throws Exception;
}
