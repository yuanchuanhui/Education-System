package org.thealphalab.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.chartdata.*;
import org.thealphalab.education.chartdata.BarChartData;
import org.thealphalab.education.chartdata.LineChartData;
import org.thealphalab.education.chartdata.PieChartData;
import org.thealphalab.education.others.RespBean;
import org.thealphalab.education.others.Utils;
import org.thealphalab.education.service.XiaofeiService;

@Controller
@ResponseBody
public class ChartDataController {

    @Autowired
    private XiaofeiService xiaofeiService;

    /**
     *  统计信息。
     */
    @RequestMapping("/consumption")
    public RespBean consumption() {
        // 月消费总额变化趋势-折线图
//        LineChartData mtcticlc =
//                xiaofeiService.selectConsumptionSumByGroupAndTime(
//                        300,
//                        2014,
//                        null,
//                        Utils.formatDateFromString("2018-1-1"),
//                        Utils.formatDateFromString("2018-6-30")
//                );
//        Object[] mcridplc =
//                LineChartData.getInstance("MonthConsumptionRatioInDifferentPlaceLineChart");
//        Object[] mtctiolc =
//                LineChartData.getInstance("MonthTotalConsumptionTrendInOtherLineChart");
//        Object[] belc =
//                LineChartData.getInstance("BehaviorEntropyLineChart");
//        Object[][] data = {mcridplc, mtctiolc, belc};
        return new RespBean("consumption", 0, null, null);
    }

    @RequestMapping("/social")
    public RespBean social() {
        Object[] snd =
                SocialNetworkData.getInstance("SocialNetworkData");
        Object[][] data = {snd};
        return new RespBean("social", 0, null, data);
    }

    @RequestMapping("/study")
    public RespBean graduation() {
//        Object[] rcflc =
//                LineChartData.getInstance("RequiredCourseFailedLineChart");
//        Object[] rcfpc =
//                PieChartData.getInstance("RequiredCourseFailedPieChart");
//        Object[] ecflc =
//                LineChartData.getInstance("ElectiveCourseFailedLineChart");
//        Object[] ecfpc =
//                PieChartData.getInstance("ElectiveCourseFailedPieChart");
//        Object[] glc =
//                LineChartData.getInstance("GradeLineChart");
//        Object[] hwc =
//                HobbyWordCloud.getInstance("HobbyWordCloud");
//        Object[] t10hecbc =
//                BarChartData.getInstance("Top10HighElectedCourseBarChart");
//        Object[] t10hbbbc =
//                BarChartData.getInstance("Top10HighBorrowedBookBarChart");
//        Object[] gelc =
//                LineChartData.getInstance("GradeEntropyLineChart");
//        Object[] t10lgcbc =
//                BarChartData.getInstance("Top10LowGradeCourseBarChart");
//        Object[][] data = {rcflc, rcfpc, ecflc, ecfpc, glc, hwc, t10hecbc, t10hbbbc, gelc, t10lgcbc};
        return new RespBean("study", 0, null, null);
    }


    @RequestMapping("/health")
    public RespBean health() {
//        Object[] t10lgcbc =
//                LineChartData.getInstance("BehaviorEntropyLineChart");
//        Object[] t10hvwbc =
//                BarChartData.getInstance("Top10HighVisitedWebsiteBarChart");
//        Object[][] data = {t10lgcbc, t10hvwbc};
        return new RespBean("health", 0, null, null);
    }


}