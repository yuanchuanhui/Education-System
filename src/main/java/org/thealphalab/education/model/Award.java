package org.thealphalab.education.model;

import java.util.Date;

public class Award {
    private Student student;

    private String arongyu;

    private String asort;

    private Date atime;

    private Boolean adelsign;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getArongyu() {
        return arongyu;
    }

    public void setArongyu(String arongyu) {
        this.arongyu = arongyu;
    }

    public String getAsort() {
        return asort;
    }

    public void setAsort(String asort) {
        this.asort = asort;
    }

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public Boolean getAdelsign() {
        return adelsign;
    }

    public void setAdelsign(Boolean adelsign) {
        this.adelsign = adelsign;
    }
}