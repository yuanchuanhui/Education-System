package org.thealphalab.education.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thealphalab.education.chartdata.ChartData;
import org.thealphalab.education.chartdata.LineChartData;
import org.thealphalab.education.chartdata.PieChartData;
import org.thealphalab.education.entity.GroupMonthResult;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.others.Utils;

import java.util.*;

@Service
public class XiaofeiService {

    @Autowired
    private XiaofeiMapper xiaofeiMapper;

    public XiaofeiService(XiaofeiMapper xiaofeiMapper) {
        this.xiaofeiMapper = xiaofeiMapper;
    }

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
        return new LineChartData("SumMoneyPerMonthByStuidAndMonths", new int[][]{allData});
    }

    public PieChartData selectRatioMoneyByStuidAndXfaddressInAllPlaces(int stuid, Date start, Date end){
        List<Map<String, Object>> data = xiaofeiMapper.selectRatioMoneyByStuidAndXfaddressInAllPlaces(
                stuid,
                start,
                end
        );
        Map<String, Double> result = new HashMap<>();
        for (Map<String, Object> map : data) {
            String key = (String) map.get("xfaddress");
            double value = (double) map.get("sum_money");
            result.put(key, value);
        }
        Map<String, Map<String, Double>> map = new HashMap<>();
        map.put(stuid + "", result);
        return new PieChartData("RatioMoneyByStuidAndXfaddressInAllPlaces", map);
    }

    public LineChartData selectConsumptionSumInCanteenByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") Date start,
            @Param("end") Date end
    ){
        List<GroupMonthResult> results = xiaofeiMapper.selectConsumptionSumByGroupAndTime(
                school,
                year,
                class_,
                Utils.formatDateToString(start),
                Utils.formatDateToString(end),
                0
        );
        // 转换为输出格式
        return Utils.groupResults2LineChartData(
                results,
                school,
                year,
                class_,
                start,
                end,
                (map, nameIndexMap, startCalender, numMonth, data, groupNames) -> {
                    // 遍历groupresult-name对，拼装data数组
                    for (Map.Entry<? extends GroupResult, String> entry : map.entrySet()) {
                        GroupMonthResult result = (GroupMonthResult)entry.getKey();
                        data[nameIndexMap.get(entry.getValue())][
                                Utils.computeMonthNumBetweenTwoMonth(
                                        startCalender.get(Calendar.YEAR),
                                        startCalender.get(Calendar.MONTH) + 1,
                                        result.getYear(),
                                        result.getMonth()
                                ) - 1
                                ] = result.getMoney();
                    }
                    return new LineChartData(
                            "MonthTotalConsumptionTrendInCanteenLineChart",
                            data,
                            Utils.getMonthNameOfChinese(0, numMonth - 1),
                            groupNames
                    );
                }
        );
    }

    public PieChartData selectConsumptionRatioInDifferentPlacesByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    ){
        List<GroupMonthResult> results = xiaofeiMapper.selectConsumptionRatioInDifferentPlacesByGroupAndTime(
            school,
            year,
            class_,
            start,
            end
        );
        // 消费地址、比例 ------- 组名
        Map<GroupResult, String> map = new HashMap<>();
        for (GroupResult result : results) {
            String name = null;
            if(school == -1){
                name = result.getStuschool() + "";
            }else if(year == -1){
                name = result.getIntyear() + "";
            }else if(class_ == null){
                name = result.getStuclass();
            }else {
                name = result.getStuclass();
            }
            map.put(result, name);
        }
        // 组名 消费地址 比例
        Map<String, Map<String, Double>> data = new HashMap<>();
        for (Map.Entry<GroupResult, String> entry : map.entrySet()) {
            Map<String, Double> tmp = data.getOrDefault(entry.getValue(), new HashMap<>());
            GroupMonthResult groupMonthResult = (GroupMonthResult) entry.getKey();
            tmp.put(groupMonthResult.getXfaddress(), groupMonthResult.getRate());
            data.put(entry.getValue(), tmp);
        }
        return new PieChartData(
                "MonthConsumptionRatioInDifferentPlaceLineChart",
                data
        );
    }

    public LineChartData selectConsumptionSumInOtherPlacesByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") Date start,
            @Param("end") Date end
    ){
        List<GroupMonthResult> results = xiaofeiMapper.selectConsumptionSumByGroupAndTime(
                school,
                year,
                class_,
                Utils.formatDateToString(start),
                Utils.formatDateToString(end),
                1
        );
        // 转换为输出格式
        return Utils.groupResults2LineChartData(
                results,
                school,
                year,
                class_,
                start,
                end,
                (map, nameIndexMap, startCalender, numMonth, data, groupNames) -> {
                    // 遍历groupresult-name对，拼装data数组
                    for (Map.Entry<? extends GroupResult, String> entry : map.entrySet()) {
                        GroupMonthResult result = (GroupMonthResult)entry.getKey();
                        data[nameIndexMap.get(entry.getValue())][
                                Utils.computeMonthNumBetweenTwoMonth(
                                        startCalender.get(Calendar.YEAR),
                                        startCalender.get(Calendar.MONTH) + 1,
                                        result.getYear(),
                                        result.getMonth()
                                ) - 1
                                ] = result.getMoney();
                    }
                    return new LineChartData(
                            "MonthTotalConsumptionTrendInOtherLineChart",
                            data,
                            Utils.getMonthNameOfChinese(0, numMonth - 1),
                            groupNames
                    );
                }
        );
    }

}
