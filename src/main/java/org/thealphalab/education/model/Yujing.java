package org.thealphalab.education.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Yujing {

  private Student stuid;
  private String yjsort;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date yjtime;
  private int yjjibie;

  public Yujing(Student stuid, String yjsort, Date yjtime, int yjjibie) {
    this.stuid = stuid;
    this.yjsort = yjsort;
    this.yjtime = yjtime;
    this.yjjibie = yjjibie;
  }

  public Student getStuid() {
    return stuid;
  }

  public void setStuid(Student stuid) {
    this.stuid = stuid;
  }

  public String getYjsort() {
    return yjsort;
  }

  public void setYjsort(String yjsort) {
    this.yjsort = yjsort;
  }

  public Date getYjtime() {
    return yjtime;
  }

  public void setYjtime(Date yjtime) {
    this.yjtime = yjtime;
  }

  public int getYjjibie() {
    return yjjibie;
  }

  public void setYjjibie(int yjjibie) {
    this.yjjibie = yjjibie;
  }

  public static Yujing[] getDemoInstance(){
    String[] yujingNames = {"消费预警", "毕业预警", "健康预警", "社交预警"};
    Yujing[] yujings = new Yujing[4];
    for (int i = 0; i < 4; i++) {
      yujings[i] = new Yujing(new Student(), yujingNames[i], new Date(), i);
    }
    return yujings;
  }

}
