package org.thealphalab.education.model;


import java.sql.Timestamp;

public class InternetData {

  private InternetApplication internetApplication;
  private Student student;
  private java.sql.Timestamp idstarttime;
  private java.sql.Timestamp idendtime;
  private boolean iddelsign;

  public InternetApplication getInternetApplication() {
    return internetApplication;
  }

  public void setInternetApplication(InternetApplication internetApplication) {
    this.internetApplication = internetApplication;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Timestamp getIdstarttime() {
    return idstarttime;
  }

  public void setIdstarttime(Timestamp idstarttime) {
    this.idstarttime = idstarttime;
  }

  public Timestamp getIdendtime() {
    return idendtime;
  }

  public void setIdendtime(Timestamp idendtime) {
    this.idendtime = idendtime;
  }

  public boolean isIddelsign() {
    return iddelsign;
  }

  public void setIddelsign(boolean iddelsign) {
    this.iddelsign = iddelsign;
  }
}
