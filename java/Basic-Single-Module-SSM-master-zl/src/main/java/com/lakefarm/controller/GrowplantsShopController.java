package com.lakefarm.controller;

import com.lakefarm.mapper.*;
import com.lakefarm.pojo.GrowPlants;
import com.lakefarm.pojo.PersonGrowplants;
import com.lakefarm.pojo.ShopGrowplants;
import com.lakefarm.pojo.User;
import com.lakefarm.service.GrowplantsShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by docker on 2017/2/23.
 */
@Controller
@RequestMapping("/lakefarm")
public class GrowplantsShopController {
    //grow_plants person_growplants shop_growplants
    static Logger log = Logger.getLogger(GrowplantsShopController.class.getName());
    @Autowired
    GrowplantsShopService growplantsShopService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    PersonGrowplantsMapper personGrowplantsMapper;
    @Autowired
    ShopGrowplantsMapper shopGrowplantsMapper;
    @RequestMapping(value = "/buyGrowplantsController.from",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String buyGrowplantsController(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("========buyGrowplantsController =========");
//        String zzIdStr = request.getParameter("zzId");
        String zzIdStr ="1";
        Integer zzId =Integer.parseInt(zzIdStr);
        String u_idStr = "1";
        Integer u_id =Integer.parseInt(u_idStr);
        //获取种子的购买数量
        String zz_allcountBuyStr ="10";
        Integer zz_allcountBuy =Integer.parseInt(zz_allcountBuyStr);

        log.info("查看种子数量");
        Integer plantCount = growplantsShopService.selectGrowplantCount(zzId);
        if (plantCount!=0){
        GrowPlants growPlants =growplantsShopService.selectGrowplantInfo(zzId);
        if(null == growPlants){
            log.info("种子id异常！"); // todo 种子id异常
            return "0";
        }else {
           log.info("种子信息为："+growPlants);


           Integer u_money =employeeMapper.findUserMoneyById(u_idStr);
            log.info("计算余额是否能够购买");
            int balance=0;
            if((balance=(u_money-growPlants.getZzPrice()*zz_allcountBuy))>=0){
                log.info("this user can pay for the thing...\nthe user balance is:"+balance);
                log.info("获取session用户信息");
                User user1 =new User();
                user1.setU_id(u_idStr);
                user1.setU_money(balance);

                log.info("查询背包该种子数量");
                Integer zz_allcount = growplantsShopService.selectGrowplantsByZzId(zzId);
                log.info("更新背包");
                PersonGrowplants personGrowplants = new PersonGrowplants();
                personGrowplants.setuId(u_id);
                personGrowplants.setZzId(zzId);
                if(null != zz_allcount){
                    zz_allcount = zz_allcountBuy+zz_allcount;
                    personGrowplants.setZzCount(zz_allcount);
                    try {
                        personGrowplantsMapper.updateByPrimaryKey(personGrowplants);
                        log.info("成功更新数据到背包！");
                    }catch (Exception e){
                        log.info("更新的person_growplants表数据异常");
                        // TODO 更新的person_growplants表数据异常！
                        return "0";
                    }
                }else {
                    personGrowplants.setZzCount(zz_allcount);
                    try {
                        personGrowplantsMapper.insert(personGrowplants);
                        log.info("成功插入数据到背包！");
                    }
                    catch (Exception e){
                        log.info("插入的person_growplants表数据异常！");
                        // TODO 插入的person_growplants表数据异常！
                        return "0";
                    }
                }
//                根据购买量减少种子数量
                plantCount = plantCount-zz_allcountBuy;
                ShopGrowplants shopGrowplants =new ShopGrowplants();
                shopGrowplants.setZzId(zzId);
                shopGrowplants.setZzAllcount(plantCount);
                shopGrowplantsMapper.updateByPrimaryKey(shopGrowplants);
                log.info("根据购买量减少种子数量成功！");

                //扣除花费的金钱
                employeeMapper.updateUserMoney(user1);
                log.info("成功消费！");
                return "恭喜您购买成功！";
            }
            else  return "对不起，您的余额不足...\n剩余金额:"+u_money;// TODO 您的余额不足

        }
        }else {
            log.info("该商品已经售罄！"); // todo 该商品已经售罄
        }
        return "";
    }

}
