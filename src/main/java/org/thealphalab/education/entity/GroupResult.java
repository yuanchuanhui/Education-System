package org.thealphalab.education.entity;

/**
  * 群体查询结果
  */
public class GroupResult {

    private int stuschool;
    private int intyear;
    private String stuclass;
    private double num;

    public GroupResult(int stuschool, int intyear, String stuclass) {
        this.stuschool = stuschool;
        this.intyear = intyear;
        this.stuclass = stuclass;
    }

    public GroupResult() {
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public String getStuclass() {
        return stuclass;
    }

    public int getStuschool() {
        return stuschool;
    }

    public void setStuschool(int stuschool) {
        this.stuschool = stuschool;
    }

    public int getIntyear() {
        return intyear;
    }

    public void setIntyear(int intyear) {
        this.intyear = intyear;
    }


    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
