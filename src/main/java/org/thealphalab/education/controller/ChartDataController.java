package org.thealphalab.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.chartdata.*;
import org.thealphalab.education.others.RespBean;
import org.thealphalab.education.others.Utils;

@Controller
@ResponseBody
public class ChartDataController {

    /**
     *  统计信息。
     */
    @RequestMapping("/consumption")
    public RespBean consumption() {
        Object[] mtcticlc =
                MonthTotalConsumptionTrendInCanteenLineChart.getInstance("MonthTotalConsumptionTrendInCanteenLineChart");
        Object[] mcridplc =
                MonthConsumptionRatioInDifferentPlaceLineChart.getInstance("MonthConsumptionRatioInDifferentPlaceLineChart");
        Object[] mtctiolc =
                MonthTotalConsumptionTrendInOtherLineChart.getInstance("MonthTotalConsumptionTrendInOtherLineChart");
        Object[] belc =
                BehaviorEntropyLineChart.getInstance("BehaviorEntropyLineChart");
        Object[][] data = {mtcticlc, mcridplc, mtcticlc, belc};
        return new RespBean("consumption", 0, null, data);
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
        Object[] rcflc =
                RequiredCourseFailedLineChart.getInstance("RequiredCourseFailedLineChart");
        Object[] rcfpc =
                RequiredCourseFailedPieChart.getInstance("RequiredCourseFailedPieChart");
        Object[] ecflc =
                ElectiveCourseFailedLineChart.getInstance("ElectiveCourseFailedLineChart");
        Object[] ecfpc =
                ElectiveCourseFailedPieChart.getInstance("ElectiveCourseFailedPieChart");
        Object[] glc =
                GradeLineChart.getInstance("GradeLineChart");
        Object[] hwc =
                HobbyWordCloud.getInstance("HobbyWordCloud");
        Object[] t10hecbc =
                Top10HighElectedCourseBarChart.getInstance("Top10HighElectedCourseBarChart");
        Object[] t10hbbbc =
                Top10HighBorrowedBookBarChart.getInstance("Top10HighBorrowedBookBarChart");
        Object[] gelc =
                GradeEntropyLineChart.getInstance("GradeEntropyLineChart");
        Object[] t10lgcbc =
                Top10LowGradeCourseBarChart.getInstance("Top10LowGradeCourseBarChart");
        Object[][] data = {rcflc, rcfpc, ecflc, ecfpc, glc, hwc, t10hecbc, t10hbbbc, gelc, t10lgcbc};
        return new RespBean("study", 0, null, data);
    }


    @RequestMapping("/health")
    public RespBean health() {
        Object[] t10lgcbc =
                BehaviorEntropyLineChart.getInstance("BehaviorEntropyLineChart");
        Object[] t10hvwbc =
                Top10HighVisitedWebsiteBarChart.getInstance("Top10HighVisitedWebsiteBarChart");
        Object[][] data = {t10lgcbc, t10hvwbc};
        return new RespBean("health", 0, null, data);
    }


}