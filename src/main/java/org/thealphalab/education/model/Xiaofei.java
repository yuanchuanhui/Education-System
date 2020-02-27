package org.thealphalab.education.model;


import java.sql.Date;

public class Xiaofei {

  private Student stuid;
  private Xiaofeileixing xflxid;
  private int xfid;
  private java.sql.Date xftime;
  private String xfaddress;
  private float xfmoney;
  private boolean xfdelsign;

  public Student getStuid() {
    return stuid;
  }

  public void setStuid(Student stuid) {
    this.stuid = stuid;
  }

  public Xiaofeileixing getXflxid() {
    return xflxid;
  }

  public void setXflxid(Xiaofeileixing xflxid) {
    this.xflxid = xflxid;
  }

  public int getXfid() {
    return xfid;
  }

  public void setXfid(int xfid) {
    this.xfid = xfid;
  }

  public Date getXftime() {
    return xftime;
  }

  public void setXftime(Date xftime) {
    this.xftime = xftime;
  }

  public String getXfaddress() {
    return xfaddress;
  }

  public void setXfaddress(String xfaddress) {
    this.xfaddress = xfaddress;
  }

  public float getXfmoney() {
    return xfmoney;
  }

  public void setXfmoney(float xfmoney) {
    this.xfmoney = xfmoney;
  }

  public boolean isXfdelsign() {
    return xfdelsign;
  }

  public void setXfdelsign(boolean xfdelsign) {
    this.xfdelsign = xfdelsign;
  }
}
