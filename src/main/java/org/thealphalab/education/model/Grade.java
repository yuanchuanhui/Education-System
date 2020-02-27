package org.thealphalab.education.model;


import java.sql.Date;

public class Grade {

  private Class_ class_;
  private Student student;
  private java.sql.Date gterm;
  private int score;
  private boolean isfail;
  private boolean gdelsign;

  public Class_ getClass_() {
    return class_;
  }

  public void setClass_(Class_ class_) {
    this.class_ = class_;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Date getGterm() {
    return gterm;
  }

  public void setGterm(Date gterm) {
    this.gterm = gterm;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean isIsfail() {
    return isfail;
  }

  public void setIsfail(boolean isfail) {
    this.isfail = isfail;
  }

  public boolean isGdelsign() {
    return gdelsign;
  }

  public void setGdelsign(boolean gdelsign) {
    this.gdelsign = gdelsign;
  }
}
