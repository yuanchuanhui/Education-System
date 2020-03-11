package org.thealphalab.education.chartdata.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LineChartDataStudy {
    private int[][] data;

    public LineChartDataStudy(int[][] data) {
        this.data = data;
    }
    public static Object[] getInstance(String subClassName){
        int[][] data = new int[4][5];
        for (int[] line : data) {
            for (int i = 0; i < line.length; i++) {
                line[i] = (int)(Math.random() * 100);
            }
        }
        Object[] objects = new Object[2];
        objects[0] = subClassName;
        objects[1] = new LineChartData(data);
        return objects;
    }

    public int[][] getData() {
        return data;
    }
}
