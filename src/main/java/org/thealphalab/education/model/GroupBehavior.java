package org.thealphalab.education.model;


import java.sql.Date;
import java.sql.Time;

public class GroupBehavior {

  private String gdid;
  private Date gbmonth;
  private float gbxws;
  private java.sql.Time gbzftime;
  private java.sql.Time gbsjtime;
  private float gbsstime;

  public String getGdid() {
    return gdid;
  }

  public void setGdid(String gdid) {
    this.gdid = gdid;
  }

  public Date getGbmonth() {
    return gbmonth;
  }

  public void setGbmonth(Date gbmonth) {
    this.gbmonth = gbmonth;
  }

  public float getGbxws() {
    return gbxws;
  }

  public void setGbxws(float gbxws) {
    this.gbxws = gbxws;
  }

  public Time getGbzftime() {
    return gbzftime;
  }

  public void setGbzftime(Time gbzftime) {
    this.gbzftime = gbzftime;
  }

  public Time getGbsjtime() {
    return gbsjtime;
  }

  public void setGbsjtime(Time gbsjtime) {
    this.gbsjtime = gbsjtime;
  }

  public float getGbsstime() {
    return gbsstime;
  }

  public void setGbsstime(float gbsstime) {
    this.gbsstime = gbsstime;
  }
}
