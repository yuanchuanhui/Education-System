package org.thealphalab.education.model;

import java.util.Date;

public class Grade {
    private Student student;

    private Course course;

    private Date gtime;

    private Integer score;

    private Float credit;

    private Integer courseType;

    private Integer isfail;

    private Boolean gdelsign;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getIsfail() {
        return isfail;
    }

    public void setIsfail(Integer isfail) {
        this.isfail = isfail;
    }

    public Boolean getGdelsign() {
        return gdelsign;
    }

    public void setGdelsign(Boolean gdelsign) {
        this.gdelsign = gdelsign;
    }
}