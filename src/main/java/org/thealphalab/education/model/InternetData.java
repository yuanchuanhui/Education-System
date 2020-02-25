package org.thealphalab.education.model;


public class InternetData {

  private long iaid;
  private long stuid;
  private java.sql.Timestamp idstarttime;
  private java.sql.Timestamp idendtime;
  private long iddelsign;


  public long getIaid() {
    return iaid;
  }

  public void setIaid(long iaid) {
    this.iaid = iaid;
  }


  public long getStuid() {
    return stuid;
  }

  public void setStuid(long stuid) {
    this.stuid = stuid;
  }


  public java.sql.Timestamp getIdstarttime() {
    return idstarttime;
  }

  public void setIdstarttime(java.sql.Timestamp idstarttime) {
    this.idstarttime = idstarttime;
  }


  public java.sql.Timestamp getIdendtime() {
    return idendtime;
  }

  public void setIdendtime(java.sql.Timestamp idendtime) {
    this.idendtime = idendtime;
  }


  public long getIddelsign() {
    return iddelsign;
  }

  public void setIddelsign(long iddelsign) {
    this.iddelsign = iddelsign;
  }

}
