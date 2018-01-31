package com.lakefarm.pojo;

/**
 * Created by cxd on 2017/2/12.
 */
public class PersonFarmTools {
    private String u_id;  //用户id
    private String nj_id;//农具id
    private int nj_count;//农具数量

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getNj_id() {
        return nj_id;
    }

    public void setNj_id(String nj_id) {
        this.nj_id = nj_id;
    }

    public int getNj_count() {
        return nj_count;
    }

    public void setNj_count(int nj_count) {
        this.nj_count = nj_count;
    }
}
