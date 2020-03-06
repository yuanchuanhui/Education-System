package org.thealphalab.education.model;


public class School {

  private int id;
  private String schoolname;

  public School(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSchoolname() {
    return schoolname;
  }

  public void setSchoolname(String schoolname) {
    this.schoolname = schoolname;
  }

  /**
    * hashset同时使用hashcode和equals来判断两个对象是否相等,只有hashcode和equals都相等,才判断两个对象相等
    */

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof School){
      return this.id == ((School)obj).id;
    }
    return super.equals(obj);
  }
}
