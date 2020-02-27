package org.thealphalab.education.model;


public class Tushu {

  private String isbn;
  private String tsname;
  private String tssort;
  private String tsauthor;
  private int tskc;
  private boolean tsdelsign;

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
