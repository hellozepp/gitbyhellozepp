package com.lakefarm.pojo;

/**
 * Created by hadoop on 17-2-3.
 */
public class User_employee {
//    用户雇员表(user_employee)
//    u_id	e_id	e_typeid	e_duration	e_starteddate	e_enddate	e_egrade	e_express	e_attract	e_defense	ng_redheal	ng_blueheal
//    用户id	雇员id	雇员类型	雇员被雇佣时长 单位：天	雇员被雇佣起始日	雇员被雇佣终止日	雇员等级	雇员经验值	雇员攻击力	雇员防御力	农雇血量	农雇蓝量

    private String u_id;
    private int e_id;
    private String e_typeid;
    private int e_duration;
    private String e_starteddate;
    private String e_enddate;
    private int e_egrade;
    private int e_express;
    private int e_attract;
    private int e_defense;
    private int ng_redheal;
    private int ng_blueheal;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String gete_typeid() {
        return e_typeid;
    }

    public void sete_typeid(String e_typeid) {
        this.e_typeid = e_typeid;
    }

    public int getE_duration() {
        return e_duration;
    }

    public void setE_duration(int e_duration) {
        this.e_duration = e_duration;
    }

    public String getE_starteddate() {
        return e_starteddate;
    }

    public void setE_starteddate(String e_starteddate) {
        this.e_starteddate = e_starteddate;
    }

    public String getE_enddate() {
        return e_enddate;
    }

    public void setE_enddate(String e_enddate) {
        this.e_enddate = e_enddate;
    }

    public int getE_egrade() {
        return e_egrade;
    }

    public void setE_egrade(int e_egrade) {
        this.e_egrade = e_egrade;
    }

    public int getE_express() {
        return e_express;
    }

    public void setE_express(int e_express) {
        this.e_express = e_express;
    }

    public int getE_attract() {
        return e_attract;
    }

    public void setE_attract(int e_attract) {
        this.e_attract = e_attract;
    }

    public int getE_defense() {
        return e_defense;
    }

    public void setE_defense(int e_defense) {
        this.e_defense = e_defense;
    }

    public int getNg_redheal() {
        return ng_redheal;
    }

    public void setNg_redheal(int ng_redheal) {
        this.ng_redheal = ng_redheal;
    }

    public int getNg_blueheal() {
        return ng_blueheal;
    }

    public void setNg_blueheal(int ng_blueheal) {
        this.ng_blueheal = ng_blueheal;
    }
}
