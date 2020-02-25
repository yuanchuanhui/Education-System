package org.thealphalab.education.model;


import java.sql.Date;

public class GroupStudy {

  private String gdid;
  private Date gsxueqi;
  private int gsfailcount;
  private float gsfailbili;


  public String getGdid() {
    return gdid;
  }

  public void setGdid(String gdid) {
    this.gdid = gdid;
  }


  public Date getGsxueqi() {
    return gsxueqi;
  }

  public void setGsxueqi(Date gsxueqi) {
    this.gsxueqi = gsxueqi;
  }


  public int getGsfailcount() {
    return gsfailcount;
  }

  public void setGsfailcount(int gsfailcount) {
    this.gsfailcount = gsfailcount;
  }


  public float getGsfailbili() {
    return gsfailbili;
  }

  public void setGsfailbili(float gsfailbili) {
    this.gsfailbili = gsfailbili;
  }

}
