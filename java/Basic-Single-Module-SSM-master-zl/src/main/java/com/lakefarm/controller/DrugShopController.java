package com.lakefarm.controller;

import com.lakefarm.pojo.Drug;
import com.lakefarm.service.DrugShopService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by docker on 2017/2/21.
 */
@Controller 
@RequestMapping("/drugshop")
public class DrugShopController {
    @Autowired
    @Qualifier(value = "drugShopService")
    DrugShopService drugShopService;
    private static Logger log = Logger.getLogger(DrugShopController.class);
    @RequestMapping(value = "/showDrugfirstPageInfo.from",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String showDrugfirstPageInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("========drugshop showDrugfirstPageInfo=========");
        //返回结果集
        String resultA="";
        String pageNumStr =request.getParameter("pageNum").trim();
        try {
            log.info("pageNum:"+pageNumStr);
            Integer pageNum = Integer.parseInt(pageNumStr);
            //获取当页单元格个数
            Integer cellCount=9;
            //开始单元格序号-1
            int startCellNum =9*(pageNum-1);
            log.info("开始单元格序号-1:"+startCellNum);
            //获取该页药品信息
            List<Drug> drugs = drugShopService.selectDrugList(startCellNum,cellCount);
            int size = drugs.size();
            log.info("this drugsPageInfo cellCount is "+size);
            for(int i = 0 ;i<size;i++){
                Drug drug =drugs.get(i);
                resultA+="ypId!$"+drug.getYpId()+"!$ypName!$"+drug.getYpName()+
                        "!$ypPrice!$"+drug.getYpPrice()+"!$ypDescription!$"+drug.getYpDescription()+
                        "!$ypRedheal!$"+drug.getYpRedheal()  +"!$ypBlueheal!$"+drug.getYpBlueheal() 
                +"!$ypSpeed!$"+drug.getYpSpeed() +"!$ypIcon!$"+drug.getYpIcon()+"!1@";
            }
            log.info(""+resultA);
        } catch (Exception e){
            log.error("DrugShopController showDrugfirstPageInfo 页码格式错误！");
            return "0";
        }
        return resultA;
    }

    //处理：统计页数
    @RequestMapping(value = "/selectDrugCount.from",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String selectDrugCount() throws Exception {
        log.info("===========统计页数===========");
        //获取当页单元格个数
        Integer cellCount=9;
        try {
            //获取药品数量
            int pagecount = drugShopService.selectDrugCount();
            log.info("++++++++获取药品数量:"+pagecount);
            //计算页数
            if(pagecount/9.0>(pagecount=pagecount/9)){
                pagecount++;
            }
            log.info("获取到药品总页数为：pagecount="+pagecount);
            return pagecount+"";
        }catch (Exception e){
            log.error("药品店商品列表为空！");
            return "0";
        }

    }
}
