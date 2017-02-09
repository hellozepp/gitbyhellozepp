package com.lakefarm.pojo;

/**
 * Created by hadoop on 17-2-3.
 */
public class Employee {
  //  e_id	e_name	e_typeid	e_duration	e_icon	e_price
  private int e_id;
  private String e_name;
  private String e_typeid;
  private int e_duration;
  private String e_icon;
  private int e_price;

  public int getE_id() {
    return e_id;
  }

  public void setE_id(int e_id) {
    this.e_id = e_id;
  }

  public String getE_name() {
    return e_name;
  }

  public void setE_name(String e_name) {
    this.e_name = e_name;
  }

  public String getE_typeid() {
    return e_typeid;
  }

  public void setE_typeid(String e_typeid) {
    this.e_typeid = e_typeid;
  }

  public int getE_duration() {
    return e_duration;
  }

  public void setE_duration(int e_duration) {
    this.e_duration = e_duration;
  }

  public String getE_icon() {
    return e_icon;
  }

  public void setE_icon(String e_icon) {
    this.e_icon = e_icon;
  }

  public int getE_price() {
    return e_price;
  }

  public void setE_price(int e_price) {
    this.e_price = e_price;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "e_id=" + e_id +
            ", e_name='" + e_name + '\'' +
            ", e_typeid='" + e_typeid + '\'' +
            ", e_duration=" + e_duration +
            ", e_icon='" + e_icon + '\'' +
            ", e_price=" + e_price +
            '}';
  }
}
