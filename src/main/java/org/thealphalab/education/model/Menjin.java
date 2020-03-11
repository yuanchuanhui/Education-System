package org.thealphalab.education.model;

import java.util.Date;

public class Menjin {
    private Integer mjid;

    private Student student;

    private Date mjtime;

    private String mjadress;

    public Integer getMjid() {
        return mjid;
    }

    public void setMjid(Integer mjid) {
        this.mjid = mjid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getMjtime() {
        return mjtime;
    }

    public void setMjtime(Date mjtime) {
        this.mjtime = mjtime;
    }

    public String getMjadress() {
        return mjadress;
    }

    public void setMjadress(String mjadress) {
        this.mjadress = mjadress;
    }
}