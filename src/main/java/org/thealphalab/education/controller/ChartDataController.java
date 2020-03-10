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
    public String consumption() {
        Object[] mtcticlc =
                MonthTotalConsumptionTrendInCanteenLineChart.getInstance("MonthTotalConsumptionTrendInCanteenLineChart");
        Object[] mcridplc =
                MonthConsumptionRatioInDifferentPlaceLineChart.getInstance("MonthConsumptionRatioInDifferentPlaceLineChart");
        Object[] mtctiolc =
                MonthTotalConsumptionTrendInOtherLineChart.getInstance("MonthTotalConsumptionTrendInOtherLineChart");
        Object[] belc =
                BehaviorEntropyLineChart.getInstance("BehaviorEntropyLineChart");
        Object[][] data = {mtcticlc, mcridplc, mtcticlc, belc};
        RespBean respBean = new RespBean("consumption", 0, null, data);
        return Utils.object2Json(respBean);
    }

    @RequestMapping("/social")
    public String social() {
        Object[] snd =
                SocialNetworkData.getInstance("SocialNetworkData");
        Object[][] data = {snd};
        RespBean respBean = new RespBean("social", 0, null, data);
        return Utils.object2Json(respBean);
    }

    @RequestMapping("/study")
    public String graduation() {
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
        RespBean respBean = new RespBean("study", 0, null, data);
        return Utils.object2Json(respBean);
    }


    @RequestMapping("/health")
    public String health() {
        Object[] t10lgcbc =
                BehaviorEntropyLineChart.getInstance("BehaviorEntropyLineChart");
        Object[] t10hvwbc =
                Top10HighVisitedWebsiteBarChart.getInstance("Top10HighVisitedWebsiteBarChart");
        Object[][] data = {t10lgcbc, t10hvwbc};
        RespBean respBean = new RespBean("health", 0, null, data);
        return Utils.object2Json(respBean);
    }




}
