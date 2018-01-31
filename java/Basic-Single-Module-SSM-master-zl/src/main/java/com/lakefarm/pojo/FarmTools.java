package com.lakefarm.pojo;
/**
 * (农具商店店实体类)
 * @author pjw
 *  2017/1/22
 */
public class FarmTools {
    // 农具id;
    private Integer nj_id;
    //农具名字;
    private String nj_name;
    //农具价格;
    private Integer nj_price;
    //农药描述;
    private String nj_description;
    //农具图片;
    private String nj_icon;
    //农具类型;
    private String nj_type;
    //农药初始单次伤害值;
    private Integer nj_oneharm;
    //农具所属战斗类型
    private String nj_combatype;
    //该农具初始防御值
    private Integer nj_defense;
    //农具被强化次数
    private Integer nj_enhancetimes;

    public FarmTools(){
    }

    public Integer getNj_id() {
        return nj_id;
    }

    public void setNj_id(Integer nj_id) {
        this.nj_id = nj_id;
    }

    public String getNj_name() {
        return nj_name;
    }

    public void setNj_name(String nj_name) {
        this.nj_name = nj_name;
    }

    public Integer getNj_price() {
        return nj_price;
    }

    public void setNj_price(Integer nj_price) {
        this.nj_price = nj_price;
    }

    public String getNj_description() {
        return nj_description;
    }

    public void setNj_description(String nj_description) {
        this.nj_description = nj_description;
    }

    public String getNj_icon() {
        return nj_icon;
    }

    public void setNj_icon(String nj_icon) {
        this.nj_icon = nj_icon;
    }

    public String getNj_type() {
        return nj_type;
    }

    public void setNj_type(String nj_type) {
        this.nj_type = nj_type;
    }

    public Integer getNj_oneharm() {
        return nj_oneharm;
    }

    public void setNj_oneharm(Integer nj_oneharm) {
        this.nj_oneharm = nj_oneharm;
    }

    public String getNj_combatype() {
        return nj_combatype;
    }

    public void setNj_combatype(String nj_combatype) {
        this.nj_combatype = nj_combatype;
    }

    public Integer getNj_defense() {
        return nj_defense;
    }

    public void setNj_defense(Integer nj_defense) {
        this.nj_defense = nj_defense;
    }

    public Integer getNj_enhancetimes() {
        return nj_enhancetimes;
    }

    public void setNj_enhancetimes(Integer nj_enhancetimes) {
        this.nj_enhancetimes = nj_enhancetimes;
    }

}
