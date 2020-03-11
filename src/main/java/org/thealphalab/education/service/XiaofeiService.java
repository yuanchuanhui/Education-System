package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thealphalab.education.chartdata.base.LineChartData;
import org.thealphalab.education.chartdata.base.PieChartData;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.others.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiaofeiService {

    @Autowired
    private XiaofeiMapper xiaofeiMapper;

    public LineChartData selectSumMoneyPerMonthByStuidAndMonths(boolean canteen, int stuid, Date start, Date end){
        List<Integer> data = xiaofeiMapper.selectSumMoneyPerMonthByStuidAndMonths(
                canteen,
                stuid,
                start,
                end
        );
        int[] allData = new int[data.size()];
        for (int i = 0; i < allData.length; i++) {
            allData[i] = data.get(i);
        }
        return new LineChartData(new int[][]{allData});
    }

    public PieChartData selectRatioMoneyByStuidAndXfaddressInAllPlaces(int stuid, Date start, Date end){
        List<Map<String, Object>> data = xiaofeiMapper.selectRatioMoneyByStuidAndXfaddressInAllPlaces(
                stuid,
                start,
                end
        );
        Map<String, Integer> result = new HashMap<>();
        for (Map<String, Object> map : data) {
            String key = (String) map.get("xfaddress");
            int value = (int)(double) map.get("sum_money");
            result.put(key, value);
        }
        return new PieChartData(result);
    }

}
