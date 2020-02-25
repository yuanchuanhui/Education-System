package org.thealphalab.education.chartdata;

public class LineChartData {

    private int[][] data;

    public LineChartData(int[][] data) {
        this.data = data;
    }

    public LineChartData getInstance(){
        int[][] data = new int[4][12];
        for (int[] line : data) {
            for (int i = 0; i < data[i].length; i++) {
                line[i] = (int)(Math.random() * 100);
            }
        }
        return new LineChartData(data);
    }

}
