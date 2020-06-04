package org.thealphalab.education.others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.thealphalab.education.chartdata.ChartData;
import org.thealphalab.education.chartdata.LineChartData;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.functional.GroupResultConsumer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    public final static String DATE_TERM_START = "01-01";
    public final static String DATE_TERM_MIDDLE = "08-15";
    public final static String DATE_TERM_END = "12-31";
    public static CustomWordFrequencyStatistics frequencyStatistics;

    public static CustomWordFrequencyStatistics getFrequencyStatistics(){
        if(frequencyStatistics == null){
            frequencyStatistics = new CustomWordFrequencyStatistics();
            frequencyStatistics.setRemoveStopWord(true);
        }
        return frequencyStatistics;
    }

    public static double computeEntropy(int[] data){
        Map<Integer, Double> pMap = new HashMap<>();
        double log2 = Math.log(2);
        double sum = 0d;
        // 计数
        for (int i : data) {
            pMap.computeIfPresent(i, (k, v) -> v + 1);
            pMap.computeIfAbsent(i, k ->  1d);
        }
        // 计算-sum(p*logp)
        for (Integer key : pMap.keySet()) {
            double value = pMap.get(key);
            double p = value / data.length;
            sum -= p * (Math.log(p) / log2);
        }
        return sum;
    }

    public static Date formatDateFromString(String textDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(textDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDateToString(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String result =
                calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return result;
    }

    public static int computeMonthNumBetweenTwoMonth(Calendar start, Calendar end){
        return computeMonthNumBetweenTwoMonth(start.get(Calendar.YEAR), start.get(Calendar.MONTH),
                end.get(Calendar.YEAR), end.get(Calendar.MONTH));
    }

    public static int computeMonthNumBetweenTwoMonth(int startYear, int startMonth, int endYear, int endMonth){
        return (endYear - startYear) * 12 + (endMonth - startMonth) + 1;
    }

    public static String object2Json(Object object){
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Iterable<CSVRecord> readCsvFile(String path, String fileName, char sep, boolean skipFirstRow){
        Reader reader = null;
        Iterable<CSVRecord> records = null;
        try {
            reader = new FileReader(path + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到，请检查文件位置。");
            return null;
        }
        try {
            records = CSVFormat.newFormat(sep).parse(reader);
        } catch (IOException e) {
            System.out.println("CSV文件格式错误");
            return null;
        }
        if(skipFirstRow){
            records.iterator().next();
        }
        return records;
    }

    /**
      * 留待以后真正实现（今后应该实现为返回一月、二月等），目前只是简单返回阿拉伯数字
      */
    public static String[] getMonthNameOfChinese(int start, int end){
        String[] result = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i] = i + "";
        }
        return result;
    }

    /**
      * 将GroupResult类型的数据转换为LineData型的数据，便于传到前台浏览器进行解析
      */
    public static LineChartData groupResults2LineChartData(
            List<? extends GroupResult> results,
            int school,
            int year,
            String class_,
            Date start,
            Date end,
            GroupResultConsumer consumer
    ){
        // <year、month、money，组名>
        Map<GroupResult, String> map = new HashMap<>();
        // <组名，索引>
        Map<String, Integer> nameIndexMap = new HashMap<>();
        // 维护以上两个索引
        int i = 0;
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
            i = updateMap(map, nameIndexMap, result, name, i);
        }
        Calendar startCalender = Calendar.getInstance();
        startCalender.setTime(start);
        Calendar endCalender = Calendar.getInstance();
        endCalender.setTime(end);
        // 行数，即子group数
        int numGroup = nameIndexMap.size();
        // 列数，即月数
        int numMonth = Utils.computeMonthNumBetweenTwoMonth(startCalender, endCalender);
        int[][] data = new int[numGroup][numMonth];
        // 组名，用于图上多条线段进行显示，如软件学院、微电子学院、2015级等标签
        String[] groupNames = new String[nameIndexMap.size()];
        for (Map.Entry<String, Integer> entry : nameIndexMap.entrySet()) {
            groupNames[entry.getValue()] = entry.getKey();
        }
        return consumer.getLineChartDataByGroupResultAndTime(map, nameIndexMap, startCalender, numMonth, data, groupNames);
    }

    private static int updateMap(Map<GroupResult, String> map, Map<String, Integer> nameIndexMap,
                         GroupResult result, String name, int i){
        map.put(result, name);
        if(!nameIndexMap.containsKey(name)) {
            nameIndexMap.put(name, i++);
        }
        return i;
    }
}
