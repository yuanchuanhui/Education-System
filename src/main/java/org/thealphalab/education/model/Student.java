package org.thealphalab.education.model;

import java.util.Date;

public class Student {
    private Integer stuid;

    private String stuname;

    private Boolean stusex;

    private Date birth;

    private School school;

    private Class_ class_;

    private String stuss;

    private String stujg;

    private String stuzzmm;

    private Boolean studelsign;

    public Student() {
    }

    public Student(Integer stuid, String stuname, Boolean stusex, Date birth, School school, Class_ class_, String stuss,
                   String stujg, String stuzzmm, Boolean studelsign) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stusex = stusex;
        this.birth = birth;
        this.stuss = stuss;
        this.stujg = stujg;
        this.stuzzmm = stuzzmm;
        this.studelsign = studelsign;
    }

    public Student(Integer stuid, String stuname, Boolean stusex, Date birth, String stuss, String stujg, String stuzzmm, Boolean studelsign) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stusex = stusex;
        this.birth = birth;
        this.stuss = stuss;
        this.stujg = stujg;
        this.stuzzmm = stuzzmm;
        this.studelsign = studelsign;
    }

    public Student(Integer stuid, String stuname, Boolean stusex, Date birth, String stuzzmm) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stusex = stusex;
        this.birth = birth;
        this.stuzzmm = stuzzmm;
    }

    public Student(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Boolean getStusex() {
        return stusex;
    }

    public void setStusex(Boolean stusex) {
        this.stusex = stusex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Class_ getClass_() {
        return class_;
    }

    public void setClass_(Class_ class_) {
        this.class_ = class_;
    }

    public String getStuss() {
        return stuss;
    }

    public void setStuss(String stuss) {
        this.stuss = stuss;
    }

    public String getStujg() {
        return stujg;
    }

    public void setStujg(String stujg) {
        this.stujg = stujg;
    }

    public String getStuzzmm() {
        return stuzzmm;
    }

    public void setStuzzmm(String stuzzmm) {
        this.stuzzmm = stuzzmm;
    }

    public Boolean getStudelsign() {
        return studelsign;
    }

    public void setStudelsign(Boolean studelsign) {
        this.studelsign = studelsign;
    }
}