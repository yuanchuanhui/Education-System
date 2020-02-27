package org.thealphalab.education.model;


import java.sql.Date;
import java.util.Map;

public class GroupConsumption {

  private String gdid;
  private Date gcmonth;
  private Map<String, Float> gcxfbili;
  private float gcavexf;

  public String getGdid() {
    return gdid;
  }

  public void setGdid(String gdid) {
    this.gdid = gdid;
  }

  public Date getGcmonth() {
    return gcmonth;
  }

  public void setGcmonth(Date gcmonth) {
    this.gcmonth = gcmonth;
  }

  public Map<String, Float> getGcxfbili() {
    return gcxfbili;
  }

  public void setGcxfbili(Map<String, Float> gcxfbili) {
    this.gcxfbili = gcxfbili;
  }

  public float getGcavexf() {
    return gcavexf;
  }

  public void setGcavexf(float gcavexf) {
    this.gcavexf = gcavexf;
  }
}
