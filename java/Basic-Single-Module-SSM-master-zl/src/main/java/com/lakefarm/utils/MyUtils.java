package com.lakefarm.utils;

import com.lakefarm.pojo.Drug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by docker on 2017/2/22.
 */
public class MyUtils {
    public static List<Drug> selectDrugPageInfo(Integer pageNum, List<Drug> drugs){
        //开始id = 9*(当前页码-1)+1 结束id = 开始id+8
        List<Drug> drugsPageInfo = new ArrayList<Drug>();
        int startPageNum =9*(pageNum-1)+1;
        int endPageNum = startPageNum+8;
        int drugsSize = drugs.size();
        for (int i = startPageNum;i<=endPageNum;i++){
            drugsPageInfo.add(drugs.get(i-1));
            drugsSize--;
            if (drugsSize==0)break;
        }
        return drugsPageInfo;
    }
}
