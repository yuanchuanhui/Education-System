package org.thealphalab.education.chartdata.base;

public class LineChartData {

    private int[][] data;
    /**
     * 相当于折线图的x和z轴，y轴为数据大小，x轴为学院或者年级或者班名，z轴为有多少条线，每条线干啥用
     */
    private String[] school = {"软件学院", "化工学院", "计算机学院", "微电子学院"};
    private String[] month = {"一月", "二月", "三月", "四月", "五月", "六月",
            "七月", "八月", "九月", "十月", "十一月", "十二月" };

    public LineChartData(int[][] data, String[] school, String[] month) {
        this.data = data;
        this.school = school;
        this.month = month;
    }

    public LineChartData(int[][] data) {
        this.data = data;
    }

    public static Object[] getInstance(String chartName){
        int[][] data = new int[4][12];
        for (int[] line : data) {
            for (int i = 0; i < line.length; i++) {
                line[i] = (int)(Math.random() * 100);
            }
        }
        return new Object[]{chartName, new LineChartData(data)};
    }

    public String[] getSchool() {
        return school;
    }

    public void setSchool(String[] school) {
        this.school = school;
    }

    public String[] getMonth() {
        return month;
    }

    public void setMonth(String[] month) {
        this.month = month;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }
}
