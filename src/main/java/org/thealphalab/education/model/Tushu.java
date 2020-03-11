package org.thealphalab.education.model;

public class Tushu {
    private String tsid;

    private String isbn;

    private String tsname;

    private String tssort;

    private String tsauthor;

    private Integer tskc;

    private Boolean tsdelsign;

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

    public Integer getTskc() {
        return tskc;
    }

    public void setTskc(Integer tskc) {
        this.tskc = tskc;
    }

    public Boolean getTsdelsign() {
        return tsdelsign;
    }

    public void setTsdelsign(Boolean tsdelsign) {
        this.tsdelsign = tsdelsign;
    }
}