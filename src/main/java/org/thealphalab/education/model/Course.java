package org.thealphalab.education.model;

public class Course {
    private String cid;

    private String cname;

    private String csort;

    private Integer tid;

    private Boolean cdelsign;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsort() {
        return csort;
    }

    public void setCsort(String csort) {
        this.csort = csort;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Boolean getCdelsign() {
        return cdelsign;
    }

    public void setCdelsign(Boolean cdelsign) {
        this.cdelsign = cdelsign;
    }
}