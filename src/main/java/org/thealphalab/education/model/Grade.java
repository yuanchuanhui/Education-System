package com.sample;


public class Grade {

  private long cid;
  private long stuid;
  private java.sql.Date gterm;
  private long score;
  private long isfail;
  private long gdelsign;


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public long getStuid() {
    return stuid;
  }

  public void setStuid(long stuid) {
    this.stuid = stuid;
  }


  public java.sql.Date getGterm() {
    return gterm;
  }

  public void setGterm(java.sql.Date gterm) {
    this.gterm = gterm;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public long getIsfail() {
    return isfail;
  }

  public void setIsfail(long isfail) {
    this.isfail = isfail;
  }


  public long getGdelsign() {
    return gdelsign;
  }

  public void setGdelsign(long gdelsign) {
    this.gdelsign = gdelsign;
  }

}
