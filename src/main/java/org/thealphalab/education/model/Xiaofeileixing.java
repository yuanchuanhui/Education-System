package org.thealphalab.education.model;


public class Xiaofeileixing {

  private int xflxid;
  private String xflxname;
  private boolean xflxdelsign;

  public Xiaofeileixing(String xflxname) {
    this.xflxname = xflxname;
  }

  public int getXflxid() {
    return xflxid;
  }

  public void setXflxid(int xflxid) {
    this.xflxid = xflxid;
  }

  public String getXflxname() {
    return xflxname;
  }

  public void setXflxname(String xflxname) {
    this.xflxname = xflxname;
  }

  public boolean isXflxdelsign() {
    return xflxdelsign;
  }

  public void setXflxdelsign(boolean xflxdelsign) {
    this.xflxdelsign = xflxdelsign;
  }
}
