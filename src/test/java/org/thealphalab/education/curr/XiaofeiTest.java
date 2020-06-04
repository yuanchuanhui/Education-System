package org.thealphalab.education.curr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import org.thealphalab.education.entity.GroupMonthResult;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.entity.Pair;
import org.thealphalab.education.mapper.XiaofeiMapper;
import org.thealphalab.education.others.Utils;
import org.thealphalab.education.service.XiaofeiService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@MybatisTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE )
public class XiaofeiTest {

    @Autowired
    private XiaofeiMapper xiaofeiMapper;

    @Test
    public void testSelectConsumptionSumByGroupAndTime(){
//        List<GroupMonthResult> list =  xiaofeiMapper.selectConsumptionSumByGroupAndTime(
//                300,
//                2014,
//                null,
//                "2018-1-1",
//                "2018-6-30"
//        );
//        List<GroupMonthResult> list1 =  xiaofeiMapper.selectConsumptionSumByGroupAndTime(
//                300,
//                2014,
//                "国际软1401",
//                "2018-1-1",
//                "2018-6-30"
//        );
        System.out.println(Utils.object2Json(new XiaofeiService(xiaofeiMapper).selectConsumptionSumInOtherPlacesByGroupAndTime(
                300,
                2014,
                "国际软1401",
                Utils.formatDateFromString("2018-1-1"),
                Utils.formatDateFromString("2018-6-30")
        )));
        System.out.println(Utils.object2Json(new XiaofeiService(xiaofeiMapper).selectConsumptionSumInOtherPlacesByGroupAndTime(
                300,
                2014,
                null,
                Utils.formatDateFromString("2018-1-1"),
                Utils.formatDateFromString("2018-6-30")
        )));
    }

    @Test
    public void testSelectConsumptionRatioInDifferentPlacesByGroupAndTime(){
        System.out.println(Utils.object2Json(new XiaofeiService(xiaofeiMapper).selectConsumptionRatioInDifferentPlacesByGroupAndTime(
                300,
                2014,
                null,
                "2018-1-1",
                "2018-6-30"
        )));
        System.out.println(Utils.object2Json(new XiaofeiService(xiaofeiMapper).selectConsumptionRatioInDifferentPlacesByGroupAndTime(
                300,
                2014,
                "国际软1401",
                "2018-1-1",
                "2018-6-30"
        )));
    }

    @Test
    public void testSelectSocialRelationDataFromXiaofeiByGroupAndTime(){
//        int school = 300;
//        int year = 2014;
//        String class_ = "国际软1401";
//        // 从数据库中查到的原始记录
//        List<Map<String, Object>> records = xiaofeiMapper.selectSocialRelationDataFromXiaofeiByGroupAndTime(
//                300,
//                2014,
//                "国际软1401",
//                "2018-1-1",
//                "2018-6-30"
//        );
//        // 分组之后的数据
//        Map<String, Map<String, List<Pair<Integer, Date>>>> groupedRecords = new HashMap<>();
//        // 按地址分组
//        Map<String, List<Map<String, Object>>> addressMap =
//                records.stream()
//                        .collect(Collectors.groupingBy(item -> (String) item.get("xfaddress")));
//        String groupName = null;
//        if(school == -1){
//            groupName = "stuschool";
//        }else if(year == -1){
//            groupName = "intyear";
//        }else if(class_ == null){
//            groupName = "stuclass";
//        }
//        for (Map.Entry<String, List<Map<String, Object>>> addressEntry : addressMap.entrySet()) {
//            System.out.println(addressEntry.getKey());
//            String finalGroupName = groupName;
//            Map<String, List<Map<String, Object>>> groupMap = null;
//            // 按组名分组
//            if(finalGroupName != null) {
//                groupMap =
//                        addressMap.get(addressEntry.getKey()).stream().
//                                collect(Collectors.groupingBy(item -> (String) item.get(finalGroupName)));
//            }else {
//                Map<String, List<Map<String, Object>>> tmp = new HashMap<>();
//                tmp.put(class_, addressEntry.getValue());
//                groupMap = tmp;
//            }
//            // 拼装
//            for (Map.Entry<String, List<Map<String, Object>>> groupEntry : groupMap.entrySet()) {
//                // 组名-数据
//                Map<String, List<Pair<Integer, Date>>> addressRecord = groupedRecords.getOrDefault(
//                        addressEntry.getKey(),
//                        new HashMap<>()
//                );
//                addressRecord.put(groupEntry.getKey(), groupEntry.getValue());
//            }
//        }
    }

}
