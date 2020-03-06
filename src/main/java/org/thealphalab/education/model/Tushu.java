package org.thealphalab.education.model;


public class Tushu {

  private String tsid;
  private String isbn;
  private String tsname;
  private String tssort;
  private String tsauthor;
  private int tskc;
  private boolean tsdelsign;

  public Tushu(String tsid, String isbn, String tsname, String tssort, String tsauthor) {
    this.tsid = tsid;
    this.isbn = isbn;
    this.tsname = tsname;
    this.tssort = tssort;
    this.tsauthor = tsauthor;
  }

  public Tushu(String tsid) {
    this.tsid = tsid;
  }

  public String getTsid() {
    return tsid;
  }

  public void setTsid(String tsid) {
    this.tsid = tsid;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTsname() {
    return tsname;
  }

  public void setTsname(String tsname) {
    this.tsname = tsname;
  }

  public String getTssort() {
    return tssort;
  }

  public void setTssort(String tssort) {
    this.tssort = tssort;
  }

  public String getTsauthor() {
    return tsauthor;
  }

  public void setTsauthor(String tsauthor) {
    this.tsauthor = tsauthor;
  }

  public int getTskc() {
    return tskc;
  }

  public void setTskc(int tskc) {
    this.tskc = tskc;
  }

  public boolean isTsdelsign() {
    return tsdelsign;
  }

  public void setTsdelsign(boolean tsdelsign) {
    this.tsdelsign = tsdelsign;
  }
}
