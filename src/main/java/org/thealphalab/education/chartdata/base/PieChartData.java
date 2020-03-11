package org.thealphalab.education.chartdata.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

public class PieChartData {

    private Map<String, Integer> data;

    public PieChartData(Map<String, Integer> data) {
        this.data = data;
    }

    public static Object[] getInstance(String subClassName){
        Map<String, Integer> data = new HashMap<>();
        data.put("一", 30);
        data.put("二", 25);
        data.put("三", 45);
        Object[] objects = new Object[2];
        objects[0] = subClassName;
        objects[1] = new PieChartData(data);
        return objects;
    }

    public void setData(Map<String, Integer> data) {
        this.data = data;
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
