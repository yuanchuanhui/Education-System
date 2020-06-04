package org.thealphalab.education.chartdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

public class HobbyWordCloud extends ChartData {

    private String className = this.getClass().getName();
    private Map<String, Integer> data;

    public HobbyWordCloud(String dataName, Map<String, Integer> data) {
        super(dataName);
        this.data = data;
    }

    public static Object[] getInstance(String className){
        Map<String, Integer> data = new HashMap<>();
        int[] heights = new int[10];
        for (int height : heights) {
            height = (int)(Math.random() * 100);
            data.put(String.valueOf(height), height);
        }
        Object[] objects = new Object[2];
        objects[0] = className;
        objects[1] = new HobbyWordCloud(null, data);
        return objects;
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
