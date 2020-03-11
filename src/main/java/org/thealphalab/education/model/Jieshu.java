package org.thealphalab.education.model;

import java.util.Date;

public class Jieshu {
    private Student student;

    private Tushu tushu;

    private Date jydate;

    private Date jsyhdate;

    private Date jsghdate;

    private Integer jscqdays;

    private Float jsfine;

    private Integer jssort;

    private Boolean jsdelsign;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tushu getTushu() {
        return tushu;
    }

    public void setTushu(Tushu tushu) {
        this.tushu = tushu;
    }

    public Date getJydate() {
        return jydate;
    }

    public void setJydate(Date jydate) {
        this.jydate = jydate;
    }

    public Date getJsyhdate() {
        return jsyhdate;
    }

    public void setJsyhdate(Date jsyhdate) {
        this.jsyhdate = jsyhdate;
    }

    public Date getJsghdate() {
        return jsghdate;
    }

    public void setJsghdate(Date jsghdate) {
        this.jsghdate = jsghdate;
    }

    public Integer getJscqdays() {
        return jscqdays;
    }

    public void setJscqdays(Integer jscqdays) {
        this.jscqdays = jscqdays;
    }

    public Float getJsfine() {
        return jsfine;
    }

    public void setJsfine(Float jsfine) {
        this.jsfine = jsfine;
    }

    public Integer getJssort() {
        return jssort;
    }

    public void setJssort(Integer jssort) {
        this.jssort = jssort;
    }

    public Boolean getJsdelsign() {
        return jsdelsign;
    }

    public void setJsdelsign(Boolean jsdelsign) {
        this.jsdelsign = jsdelsign;
    }
}