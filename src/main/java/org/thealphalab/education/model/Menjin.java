package com.sample;


public class Menjin {

  private long mjid;
  private long stuid;
  private java.sql.Date mjtime;
  private String mjadress;


  public long getMjid() {
    return mjid;
  }

  public void setMjid(long mjid) {
    this.mjid = mjid;
  }


  public long getStuid() {
    return stuid;
  }

  public void setStuid(long stuid) {
    this.stuid = stuid;
  }


  public java.sql.Date getMjtime() {
    return mjtime;
  }

  public void setMjtime(java.sql.Date mjtime) {
    this.mjtime = mjtime;
  }


  public String getMjadress() {
    return mjadress;
  }

  public void setMjadress(String mjadress) {
    this.mjadress = mjadress;
  }

}
