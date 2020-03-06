package org.thealphalab.education.model;


import java.util.Date;

public class Grade {

  private Course course;
  private Student student;
  private java.util.Date gtime;
  private int score;
  private float credit;
  private int courseType;
  private int isfail;
  private boolean gdelsign;

  public Grade(Course course, Student student, Date gtime, int score, float credit, int courseType) {
    this.course = course;
    this.student = student;
    this.gtime = gtime;
    this.score = score;
    this.credit = credit;
    this.courseType = courseType;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public void setGtime(Date gtime) {
    this.gtime = gtime;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Date getGtime() {
    return gtime;
  }

  public void setGTime(Date gtime) {
    this.gtime = gtime;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getIsfail() {
    return isfail;
  }

  public void setIsfail(int isfail) {
    this.isfail = isfail;
  }

  public boolean isGdelsign() {
    return gdelsign;
  }

  public void setGdelsign(boolean gdelsign) {
    this.gdelsign = gdelsign;
  }

  public float getCredit() {
    return credit;
  }

  public void setCredit(float credit) {
    this.credit = credit;
  }

  public int getCourseType() {
    return courseType;
  }

  public void setCourseType(int courseType) {
    this.courseType = courseType;
  }

  @Override
  public String toString() {
    return "Grade{" +
            "course=" + course +
            ", student=" + student +
            ", gtime=" + gtime +
            ", score=" + score +
            ", credit=" + credit +
            ", courseType=" + courseType +
            ", isfail=" + isfail +
            ", gdelsign=" + gdelsign +
            '}';
  }
}
