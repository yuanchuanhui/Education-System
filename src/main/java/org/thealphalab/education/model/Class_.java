package org.thealphalab.education.model;


public class Class_ {

  private int id;
  private String classname;
  private java.sql.Date year;
  private School school;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }


  public java.sql.Date getYear() {
    return year;
  }

  public void setYear(java.sql.Date year) {
    this.year = year;
  }


  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

}
