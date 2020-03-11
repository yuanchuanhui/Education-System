package org.thealphalab.education.model;

import java.util.Date;

public class Yujing {
    private Student student;

    private String yjsort;

    private Date yjtime;

    private String yjjibie;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getYjjibie() {
        return yjjibie;
    }

    public void setYjjibie(String yjjibie) {
        this.yjjibie = yjjibie;
    }
}