package org.thealphalab.education.chartdata.base;

import java.util.HashMap;
import java.util.Map;

public class PieChartData {

    private String className = this.getClass().getName();
    private Map<String, Integer> data;

    public PieChartData(Map<String, Integer> data) {
        this.data = data;
    }

    public PieChartData getInstance(){
        Map<String, Integer> data = new HashMap<>();
        data.put("一", 30);
        data.put("二", 25);
        data.put("三", 45);
        return new PieChartData(data);
    }

}
