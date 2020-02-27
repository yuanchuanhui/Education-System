package org.thealphalab.education.model;

import java.util.Map;

public class GroupData {

  private String gdid;
  private Map<String, Float> gdsex;
  private Map<Integer, Float> gdage;
  private Map<String, Float> gdzzmm;
  private Map<String, Float> gdmz;
  private Map<String, Float> gdsyd;

  public String getGdid() {
    return gdid;
  }

  public void setGdid(String gdid) {
    this.gdid = gdid;
  }

  public Map<String, Float> getGdsex() {
    return gdsex;
  }

  public void setGdsex(Map<String, Float> gdsex) {
    this.gdsex = gdsex;
  }

  public Map<Integer, Float> getGdage() {
    return gdage;
  }

  public void setGdage(Map<Integer, Float> gdage) {
    this.gdage = gdage;
  }

  public Map<String, Float> getGdzzmm() {
    return gdzzmm;
  }

  public void setGdzzmm(Map<String, Float> gdzzmm) {
    this.gdzzmm = gdzzmm;
  }

  public Map<String, Float> getGdmz() {
    return gdmz;
  }

  public void setGdmz(Map<String, Float> gdmz) {
    this.gdmz = gdmz;
  }

  public Map<String, Float> getGdsyd() {
    return gdsyd;
  }

  public void setGdsyd(Map<String, Float> gdsyd) {
    this.gdsyd = gdsyd;
  }
}
