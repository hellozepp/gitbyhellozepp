package com.lakefarm.pojo;

import java.util.List;

/**
 * Created by docker on 2017/2/21.
 */
public class DrugVo extends Drug {
    public Integer drugCountNum;
    public List<Drug> drugs;
    public Integer getDrugCountNum() {
        return drugCountNum;
    }

    public void setDrugCountNum(Integer drugCountNum) {
        this.drugCountNum = drugCountNum;
    }

}
