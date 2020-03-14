package org.thealphalab.education.chartdata.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LineChartDataStudy {

    private int[][] data;
    private String[] x = {"软件学院", "化工学院", "计算机学院", "微电子学院","数学学院"};
    private String[] z = {"Java","数据结构","计算机组成原理","数据库" };

    public LineChartDataStudy(int[][] data, String[] x, String[] z) {
        this.data = data;
        this.x = x;
        this.z = z;
    }

    public LineChartDataStudy(int[][] data) {
        this.data = data;
    }
    public static Object[] getInstance(String chartName){
        int[][] data = new int[4][5];
        for (int[] line : data) {
            for (int i = 0; i < line.length; i++) {
                line[i] = (int)(Math.random() * 100);
            }
        }
        return new Object[]{chartName, new LineChartDataStudy(data)};
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
