package org.thealphalab.education.model;

import java.util.Date;

public class Xiaofei {
    private Integer xfid;

    private Student student;

    private Xiaofeileixing xflx;

    private Date xftime;

    private String xfaddress;

    private Float xfmoney;

    private Boolean xfdelsign;

    public Integer getXfid() {
        return xfid;
    }

    public void setXfid(Integer xfid) {
        this.xfid = xfid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Xiaofeileixing getXflx() {
        return xflx;
    }

    public void setXflx(Xiaofeileixing xflx) {
        this.xflx = xflx;
    }

    public Date getXftime() {
        return xftime;
    }

    public void setXftime(Date xftime) {
        this.xftime = xftime;
    }

    public String getXfaddress() {
        return xfaddress;
    }

    public void setXfaddress(String xfaddress) {
        this.xfaddress = xfaddress;
    }

    public Float getXfmoney() {
        return xfmoney;
    }

    public void setXfmoney(Float xfmoney) {
        this.xfmoney = xfmoney;
    }

    public Boolean getXfdelsign() {
        return xfdelsign;
    }

    public void setXfdelsign(Boolean xfdelsign) {
        this.xfdelsign = xfdelsign;
    }
}