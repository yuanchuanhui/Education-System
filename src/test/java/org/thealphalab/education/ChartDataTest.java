package org.thealphalab.education;

import org.thealphalab.education.controller.ChartDataController;
import org.thealphalab.education.others.Utils;
import org.thealphalab.education.chartdata.*;

public class ChartDataTest {

    public static void main(String[] args) {
//        System.out.println(Utils.object2Json(BehaviorEntropyLineChart.getInstance("BehaviorEntropyLineChart")));
//        System.out.println(Utils.object2Json(ElectiveCourseFailedLineChart.getInstance("ElectiveCourseFailedLineChart")));
//        System.out.println(Utils.object2Json(ElectiveCourseFailedPieChart.getInstance("ElectiveCourseFailedPieChart")));
//        System.out.println(Utils.object2Json(GradeEntropyLineChart.getInstance("GradeEntropyLineChart")));
//        System.out.println(Utils.object2Json(GradeLineChart.getInstance("GradeLineChart")));
//        System.out.println(Utils.object2Json(HobbyWordCloud.getInstance("HobbyWordCloud")));
//        System.out.println(Utils.object2Json(MonthConsumptionRatioInDifferentPlaceLineChart.getInstance("MonthConsumptionRatioInDifferentPlaceLineChart")));
//        System.out.println(Utils.object2Json(MonthTotalConsumptionTrendInCanteenLineChart.getInstance("MonthTotalConsumptionTrendInCanteenLineChart")));
//        System.out.println(Utils.object2Json(MonthTotalConsumptionTrendInOtherLineChart.getInstance("MonthTotalConsumptionTrendInOtherLineChart")));
//        System.out.println(Utils.object2Json(RequiredCourseFailedLineChart.getInstance("RequiredCourseFailedLineChart")));
//        System.out.println(Utils.object2Json(RequiredCourseFailedPieChart.getInstance("RequiredCourseFailedPieChart")));
//        System.out.println(Utils.object2Json(SocialNetworkData.getInstance("SocialNetworkData")));
//        System.out.println(Utils.object2Json(Top10HighBorrowedBookBarChart.getInstance("Top10HighBorrowedBookBarChart")));
//        System.out.println(Utils.object2Json(Top10HighElectedCourseBarChart.getInstance("Top10HighElectedCourseBarChart")));
//        System.out.println(Utils.object2Json(Top10HighVisitedWebsiteBarChart.getInstance("Top10HighVisitedWebsiteBarChart")));
//        System.out.println(Utils.object2Json(Top10LowGradeCourseBarChart.getInstance("Top10LowGradeCourseBarChart")));
        System.out.println(new ChartDataController().consumption());
        System.out.println(new ChartDataController().social());
        System.out.println(new ChartDataController().health());
        System.out.println(new ChartDataController().graduation());
    }

}
