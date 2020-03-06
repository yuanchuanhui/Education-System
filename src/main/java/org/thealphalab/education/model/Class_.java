package org.thealphalab.education.model;


import java.util.Date;

public class Class_ {

  private String classname;
  private Date year;
  private School school;

  public Class_(String classname, School school) {
    this.classname = classname;
    this.school = school;
  }

  public Class_(String classname, Date year, School school) {
    this.classname = classname;
    this.year = year;
    this.school = school;
  }

  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
  }

  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

  @Override
  public boolean equals(Object obj) {
    Class_ class_ = (Class_)obj;
    return class_.classname.equals(this.classname);
  }

  @Override
  public int hashCode() {
    return this.classname.hashCode();
  }
}
