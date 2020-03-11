package org.thealphalab.education.model;

import java.util.Date;

public class Internetdata {
    private Internetapplication ia;

    private Student student;

    private Date idstarttime;

    private Date idendtime;

    private Boolean iddelsign;

    public Internetapplication getIa() {
        return ia;
    }

    public void setIa(Internetapplication ia) {
        this.ia = ia;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getIdstarttime() {
        return idstarttime;
    }

    public void setIdstarttime(Date idstarttime) {
        this.idstarttime = idstarttime;
    }

    public Date getIdendtime() {
        return idendtime;
    }

    public void setIdendtime(Date idendtime) {
        this.idendtime = idendtime;
    }

    public Boolean getIddelsign() {
        return iddelsign;
    }

    public void setIddelsign(Boolean iddelsign) {
        this.iddelsign = iddelsign;
    }
}