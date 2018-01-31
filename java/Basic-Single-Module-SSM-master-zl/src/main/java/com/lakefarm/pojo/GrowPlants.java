package com.lakefarm.pojo;

public class GrowPlants {
    private Integer zzId;

    private String zzType;

    private String zzName;

    private Integer zzGrowntime;

    private Integer zzPrice;

    private String zzDescription;

    private Integer zzMinplantcount;

    private String zzSicktype;

    private String zzIcon;

    private Integer zzProduction;

    private Integer zzSinglehfuse;

    public Integer getZzId() {
        return zzId;
    }

    public void setZzId(Integer zzId) {
        this.zzId = zzId;
    }

    public String getZzType() {
        return zzType;
    }

    public void setZzType(String zzType) {
        this.zzType = zzType == null ? null : zzType.trim();
    }

    public String getZzName() {
        return zzName;
    }

    public void setZzName(String zzName) {
        this.zzName = zzName == null ? null : zzName.trim();
    }

    public Integer getZzGrowntime() {
        return zzGrowntime;
    }

    public void setZzGrowntime(Integer zzGrowntime) {
        this.zzGrowntime = zzGrowntime;
    }

    public Integer getZzPrice() {
        return zzPrice;
    }

    public void setZzPrice(Integer zzPrice) {
        this.zzPrice = zzPrice;
    }

    public String getZzDescription() {
        return zzDescription;
    }

    public void setZzDescription(String zzDescription) {
        this.zzDescription = zzDescription == null ? null : zzDescription.trim();
    }

    public Integer getZzMinplantcount() {
        return zzMinplantcount;
    }

    public void setZzMinplantcount(Integer zzMinplantcount) {
        this.zzMinplantcount = zzMinplantcount;
    }

    public String getZzSicktype() {
        return zzSicktype;
    }

    public void setZzSicktype(String zzSicktype) {
        this.zzSicktype = zzSicktype == null ? null : zzSicktype.trim();
    }

    public String getZzIcon() {
        return zzIcon;
    }

    public void setZzIcon(String zzIcon) {
        this.zzIcon = zzIcon == null ? null : zzIcon.trim();
    }

    public Integer getZzProduction() {
        return zzProduction;
    }

    public void setZzProduction(Integer zzProduction) {
        this.zzProduction = zzProduction;
    }

    public Integer getZzSinglehfuse() {
        return zzSinglehfuse;
    }

    public void setZzSinglehfuse(Integer zzSinglehfuse) {
        this.zzSinglehfuse = zzSinglehfuse;
    }
}