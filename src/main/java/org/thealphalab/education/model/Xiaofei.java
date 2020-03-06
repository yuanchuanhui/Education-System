package org.thealphalab.education.model;


import java.util.Date;

public class Xiaofei {

  private int xfid;
  private Student student;
  private Xiaofeileixing xflx;
  private Date xftime;
  private String xfaddress;
  private float xfmoney;
  private boolean xfdelsign;

  public Xiaofei(Student student, Xiaofeileixing xflx, Date xftime, String xfaddress, float xfmoney) {
    this.student = student;
    this.xflx = xflx;
    this.xftime = xftime;
    this.xfaddress = xfaddress;
    this.xfmoney = xfmoney;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Xiaofeileixing getXflx() {
    return xflx;
  }

  public void setXflx(Xiaofeileixing xflx) {
    this.xflx = xflx;
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

  @Override
  public String toString() {
    return "Xiaofei{" +
            "student=" + student +
            ", xflx=" + xflx +
            ", xfid=" + xfid +
            ", xftime=" + xftime +
            ", xfaddress='" + xfaddress + '\'' +
            ", xfmoney=" + xfmoney +
            ", xfdelsign=" + xfdelsign +
            '}';
  }
}
