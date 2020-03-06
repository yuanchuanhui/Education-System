package org.thealphalab.education.model;


import lombok.Data;

import java.util.Date;

@Data
public class Student {

  private int stuid;
  private String stuname;
  private boolean stusex;
  private Date birth;
  private School stuschool;
  private Class_ stuclass;
  private String stuss;
  private String stujg;
  private String stuzzmm;
  private boolean studelsign;

  public Student() {
  }

  public Student(int stuid) {
    this.stuid = stuid;
  }

  public Student(int stuid, String stuname, boolean stusex, Date birth, String stuzzmm) {
    this.stuid = stuid;
    this.stuname = stuname;
    this.stusex = stusex;
    this.birth = birth;
    this.stuzzmm = stuzzmm;
  }

}
