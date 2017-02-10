package org.controller4;

import org.entity.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by andilyliao on 17-1-6.
 */
@Controller
@RequestMapping("/day02")
public class JSONController {

    @RequestMapping(value="/json.from", method = RequestMethod.GET)
    public @ResponseBody
    Shop getShopInJSON() {

        //测试数据
        Shop shop = new Shop();
        System.out.println("Shop");
        shop.setName("Eric");
        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});

        return shop;

    }

}
