package org.thealphalab.education.entity;

public class ChartDataRespone {

    private int[][] data;
    private String[] x;
    private String[] z;

    public ChartDataRespone(int[][] data, String[] x, String[] z) {
        this.data = data;
        this.x = x;
        this.z = z;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getX() {
        return x;
    }

    public void setX(String[] x) {
        this.x = x;
    }

    public String[] getZ() {
        return z;
    }

    public void setZ(String[] z) {
        this.z = z;
    }
}
