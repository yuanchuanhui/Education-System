package org.thealphalab.education.model;


import java.sql.Date;

public class GroupLibrary {

  private String gdid;
  private Date glmonth;
  private float glavejy;
  private float glavesc;

  public String getGdid() {
    return gdid;
  }

  public void setGdid(String gdid) {
    this.gdid = gdid;
  }

  public Date getGlmonth() {
    return glmonth;
  }

  public void setGlmonth(Date glmonth) {
    this.glmonth = glmonth;
  }

  public float getGlavejy() {
    return glavejy;
  }

  public void setGlavejy(float glavejy) {
    this.glavejy = glavejy;
  }

  public float getGlavesc() {
    return glavesc;
  }

  public void setGlavesc(float glavesc) {
    this.glavesc = glavesc;
  }
}
