package org.thealphalab.education.model;

public class Teacher {
    private Integer tid;

    private String tname;

    private Boolean tsex;

    private String tpost;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Boolean getTsex() {
        return tsex;
    }

    public void setTsex(Boolean tsex) {
        this.tsex = tsex;
    }

    public String getTpost() {
        return tpost;
    }

    public void setTpost(String tpost) {
        this.tpost = tpost;
    }
}