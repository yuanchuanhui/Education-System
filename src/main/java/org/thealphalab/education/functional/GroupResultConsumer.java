package org.thealphalab.education.functional;

import org.thealphalab.education.chartdata.LineChartData;
import org.thealphalab.education.entity.GroupResult;

import java.util.Calendar;
import java.util.Map;

public interface GroupResultConsumer {

    LineChartData getLineChartDataByGroupResultAndTime(
            Map<? extends GroupResult, String> map,
            Map<String, Integer> nameIndexMap,
            Calendar startCalender,
            int numMonth,
            int[][] data,
            String[] groupNames
    );

}
