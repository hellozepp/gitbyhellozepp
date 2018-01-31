package com.lakefarm.pojo;

import java.util.List;

public class Drug {
    private Integer ypId;

    private String ypName;

    private Integer ypPrice;

    private String ypDescription;

    private Integer ypRedheal;

    private Integer ypBlueheal;

    private Integer ypSpeed;

    private String ypIcon;

    public Integer getYpId() {
        return ypId;
    }

    public void setYpId(Integer ypId) {
        this.ypId = ypId;
    }

    public String getYpName() {
        return ypName;
    }

    public void setYpName(String ypName) {
        this.ypName = ypName == null ? null : ypName.trim();
    }

    public Integer getYpPrice() {
        return ypPrice;
    }

    public void setYpPrice(Integer ypPrice) {
        this.ypPrice = ypPrice;
    }

    public String getYpDescription() {
        return ypDescription;
    }

    public void setYpDescription(String ypDescription) {
        this.ypDescription = ypDescription == null ? null : ypDescription.trim();
    }

    public Integer getYpRedheal() {
        return ypRedheal;
    }

    public void setYpRedheal(Integer ypRedheal) {
        this.ypRedheal = ypRedheal;
    }

    public Integer getYpBlueheal() {
        return ypBlueheal;
    }

    public void setYpBlueheal(Integer ypBlueheal) {
        this.ypBlueheal = ypBlueheal;
    }

    public Integer getYpSpeed() {
        return ypSpeed;
    }

    public void setYpSpeed(Integer ypSpeed) {
        this.ypSpeed = ypSpeed;
    }

    public String getYpIcon() {
        return ypIcon;
    }

    public void setYpIcon(String ypIcon) {
        this.ypIcon = ypIcon == null ? null : ypIcon.trim();
    }
}