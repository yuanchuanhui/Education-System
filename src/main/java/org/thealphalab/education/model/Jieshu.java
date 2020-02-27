package org.thealphalab.education.model;


import java.sql.Date;

public class Jieshu {

  private Student student;
  private Tushu tushu;
  private java.sql.Date jydate;
  private java.sql.Date jsyhdate;
  private java.sql.Date jsghdate;
  private int jscqdays;
  private float jsfine;
  private int jssort;
  private boolean jsdelsign;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Tushu getTushu() {
    return tushu;
  }

  public void setTushu(Tushu tushu) {
    this.tushu = tushu;
  }

  public Date getJydate() {
    return jydate;
  }

  public void setJydate(Date jydate) {
    this.jydate = jydate;
  }

  public Date getJsyhdate() {
    return jsyhdate;
  }

  public void setJsyhdate(Date jsyhdate) {
    this.jsyhdate = jsyhdate;
  }

  public Date getJsghdate() {
    return jsghdate;
  }

  public void setJsghdate(Date jsghdate) {
    this.jsghdate = jsghdate;
  }

  public int getJscqdays() {
    return jscqdays;
  }

  public void setJscqdays(int jscqdays) {
    this.jscqdays = jscqdays;
  }

  public float getJsfine() {
    return jsfine;
  }

  public void setJsfine(float jsfine) {
    this.jsfine = jsfine;
  }

  public int getJssort() {
    return jssort;
  }

  public void setJssort(int jssort) {
    this.jssort = jssort;
  }

  public boolean isJsdelsign() {
    return jsdelsign;
  }

  public void setJsdelsign(boolean jsdelsign) {
    this.jsdelsign = jsdelsign;
  }
}
