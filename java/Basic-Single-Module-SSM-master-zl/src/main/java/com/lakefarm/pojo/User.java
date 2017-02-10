package com.lakefarm.pojo;
/**
 * 　userinfo(个人信息实体)
 * @author pjw
 *
 */
public class User {
    /**
     * 用户id
     */
    private String u_id;
    /**
     * 用户名
     */
    private String u_name;
    /**
     * 用户类型
     */
    private String u_type;
    /**
     * 用户砖石数量
     */
    private Integer u_diamond;
    /**
     * 用户金钱数量
     */
    private Integer u_money;
    /**
     * 用户等级
     */
    private Integer u_grade;
    /**
     * 用户地区
     */
    private String u_area;
    /**
     * 用户头像
     */
    private String u_icon;
    /**
     * 用户身份证号
     */
    private String u_IdCard;
    /**
     * 用户电话
     */
    private String u_phone;
    /**
     * 用户生日
     */
    private String u_birthdate;
    /**
     * 用户具体描述
     */
    private String u_description;
    /**
     * 用户密码
     */
    private String u_pwd;
    /**
     * 用户用户初始体力值
     */
    private Integer u_vitality;

    public User(){
    }

    public String getU_pwd() {
        return u_pwd;
    }
    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }
    public Integer getU_vitality() {
        return u_vitality;
    }
    public void setU_vitality(Integer u_vitality) {
        this.u_vitality = u_vitality;
    }
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
    public String getU_type() {
        return u_type;
    }
    public void setU_type(String u_type) {
        this.u_type = u_type;
    }
    public Integer getU_diamond() {
        return u_diamond;
    }
    public void setU_diamond(Integer u_diamond) {
        this.u_diamond = u_diamond;
    }
    public Integer getU_money() {
        return u_money;
    }
    public void setU_money(Integer u_money) {
        this.u_money = u_money;
    }
    public Integer getU_grade() {
        return u_grade;
    }
    public void setU_grade(Integer u_grade) {
        this.u_grade = u_grade;
    }
    public String getU_area() {
        return u_area;
    }
    public void setU_area(String u_area) {
        this.u_area = u_area;
    }
    public String getU_icon() {
        return u_icon;
    }
    public void setU_icon(String u_icon) {
        this.u_icon = u_icon;
    }
    public String getU_IdCard() {
        return u_IdCard;
    }
    public void setU_IdCard(String u_IdCard) {
        this.u_IdCard = u_IdCard;
    }
    public String getU_phone() {
        return u_phone;
    }
    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }
    public String getU_birthdate() {
        return u_birthdate;
    }
    public void setU_birthdate(String u_birthdate) {
        this.u_birthdate = u_birthdate;
    }
    public String getU_description() {
        return u_description;
    }
    public void setU_description(String u_description) {
        this.u_description = u_description;
    }

}
