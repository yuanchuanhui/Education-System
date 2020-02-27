package org.thealphalab.education.model;


public class Course {

  private int cid;
  private String cname;
  private String csort;
  private Teacher teacher;
  private boolean cdelsign;

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public String getCsort() {
    return csort;
  }

  public void setCsort(String csort) {
    this.csort = csort;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public boolean isCdelsign() {
    return cdelsign;
  }

  public void setCdelsign(boolean cdelsign) {
    this.cdelsign = cdelsign;
  }
}
