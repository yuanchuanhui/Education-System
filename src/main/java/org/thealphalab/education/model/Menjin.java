package org.thealphalab.education.model;


import java.sql.Date;

public class Menjin {

  private int mjid;
  private Student student;
  private java.sql.Date mjtime;
  private String mjadress;

  public int getMjid() {
    return mjid;
  }

  public void setMjid(int mjid) {
    this.mjid = mjid;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Date getMjtime() {
    return mjtime;
  }

  public void setMjtime(Date mjtime) {
    this.mjtime = mjtime;
  }

  public String getMjadress() {
    return mjadress;
  }

  public void setMjadress(String mjadress) {
    this.mjadress = mjadress;
  }
}
