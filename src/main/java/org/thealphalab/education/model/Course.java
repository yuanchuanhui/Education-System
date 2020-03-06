package org.thealphalab.education.model;


public class Course {

  private String cid;
  private String cname;
  private String csort;
  private Teacher teacher;
  private boolean cdelsign;

  public Course(String cid, String cname) {
    this.cid = cid;
    this.cname = cname;
  }

  public Course(String cid) {
    this.cid = cid;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
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
