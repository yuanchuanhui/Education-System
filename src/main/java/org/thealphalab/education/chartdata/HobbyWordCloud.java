package org.thealphalab.education.chartdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.thealphalab.education.chartdata.base.BarChartData;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class HobbyWordCloud {

    private String className = this.getClass().getName();
    private Map<String, Integer> data;

    public HobbyWordCloud(Map<String, Integer> data) {
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
        objects[1] = new HobbyWordCloud(data);
        return objects;
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
