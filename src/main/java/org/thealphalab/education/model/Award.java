package org.thealphalab.education.model;


import java.sql.Date;

public class Award {

  private Student student;
  private String arongyu;
  private String asort;
  private java.sql.Date atime;
  private boolean adelsign;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public String getArongyu() {
    return arongyu;
  }

  public void setArongyu(String arongyu) {
    this.arongyu = arongyu;
  }

  public String getAsort() {
    return asort;
  }

  public void setAsort(String asort) {
    this.asort = asort;
  }

  public Date getAtime() {
    return atime;
  }

  public void setAtime(Date atime) {
    this.atime = atime;
  }

  public boolean isAdelsign() {
    return adelsign;
  }

  public void setAdelsign(boolean adelsign) {
    this.adelsign = adelsign;
  }
}
