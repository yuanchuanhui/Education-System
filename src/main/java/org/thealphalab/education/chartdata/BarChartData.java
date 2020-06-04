package org.thealphalab.education.chartdata;

import java.util.HashMap;
import java.util.Map;

public class BarChartData extends ChartData {

    private Map<String, Integer> data;

    public BarChartData(String dataName, Map<String, Integer> data) {
        super(dataName);
        this.data = data;
    }

    public static Object[] getInstance(String subClassName){
        Map<String, Integer> data = new HashMap<>();
        int[] heights = new int[10];
        for (int height : heights) {
            height = (int)(Math.random() * 100);
            data.put(String.valueOf(height), height);
        }
        Object[] objects = new Object[2];
        objects[0] = subClassName;
        objects[1] = new BarChartData(null, data);
        return objects;
    }

    public Map<String, Integer> getData() {
        return data;
    }

    public void setData(Map<String, Integer> data) {
        this.data = data;
    }
}
