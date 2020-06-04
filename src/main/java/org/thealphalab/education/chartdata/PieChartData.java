package org.thealphalab.education.chartdata;

import java.util.HashMap;
import java.util.Map;

public class PieChartData extends ChartData {

    // 组名：项目名：百分比
    private Map<String, Map<String, Double>> data;

    public PieChartData(String dataName, Map<String, Map<String, Double>> data) {
        super(dataName);
        this.data = data;
    }

    public static Object[] getInstance(String subClassName){
        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> subData = new HashMap<>();
        subData.put("一", (double) 30);
        subData.put("二", (double) 25);
        subData.put("三", (double) 45);
        data.put("1", subData);
        Object[] objects = new Object[2];
        objects[0] = subClassName;
        objects[1] = new PieChartData(null, data);
        return objects;
    }

    public void setData(Map<String, Map<String, Double>> data) {
        this.data = data;
    }

    public Map<String, Map<String, Double>> getData() {
        return data;
    }
}
