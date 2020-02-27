package org.thealphalab.education.model;


import java.sql.Date;

public class Student {

  private int stuid;
  private String stuname;
  private boolean stusex;
  private java.sql.Date birth;
  private School stuschool;
  private Class_ stuclass;
  private String stuss;
  private String stujg;
  private String stuzzmm;
  private boolean studelsign;

  public int getStuid() {
    return stuid;
  }

  public void setStuid(int stuid) {
    this.stuid = stuid;
  }

  public String getStuname() {
    return stuname;
  }

  public void setStuname(String stuname) {
    this.stuname = stuname;
  }

  public boolean isStusex() {
    return stusex;
  }

  public void setStusex(boolean stusex) {
    this.stusex = stusex;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public School getStuschool() {
    return stuschool;
  }

  public void setStuschool(School stuschool) {
    this.stuschool = stuschool;
  }

  public Class_ getStuclass() {
    return stuclass;
  }

  public void setStuclass(Class_ stuclass) {
    this.stuclass = stuclass;
  }

  public String getStuss() {
    return stuss;
  }

  public void setStuss(String stuss) {
    this.stuss = stuss;
  }

  public String getStujg() {
    return stujg;
  }

  public void setStujg(String stujg) {
    this.stujg = stujg;
  }

  public String getStuzzmm() {
    return stuzzmm;
  }

  public void setStuzzmm(String stuzzmm) {
    this.stuzzmm = stuzzmm;
  }

  public boolean isStudelsign() {
    return studelsign;
  }

  public void setStudelsign(boolean studelsign) {
    this.studelsign = studelsign;
  }
}
