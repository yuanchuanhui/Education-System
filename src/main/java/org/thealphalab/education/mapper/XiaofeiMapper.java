package org.thealphalab.education.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.entity.GroupMonthResult;
import org.thealphalab.education.model.Xiaofei;

@Repository
public interface XiaofeiMapper {

    int insert(Xiaofei record);
    int insertAll(List<Xiaofei> xiaofeis);

    int deleteByPrimaryKey(Integer xfid);
    int deleteByStuid(Integer stuid);

    int updateByPrimaryKey(Xiaofei record);

    Xiaofei selectByPrimaryKey(Integer xfid);
    List<Integer> selectSumMoneyPerMonthByStuidAndMonths(
            @Param("canteen") boolean canteen,
            @Param("stuid") int stuid,
            @Param("start") Date start,
            @Param("end") Date end
    );
    List<Xiaofei> selectAll();
    List<Map<String, Object>> selectRatioMoneyByStuidAndXfaddressInAllPlaces(
            @Param("stuid") int stuid, @Param("start") Date start, @Param("end") Date end);
    /**
      * <!--查询某个groupid所对应的群体在食堂(或非食堂)每月消费总额的变化趋势-->
     * @param type 0 为食堂，1为非食堂
      */
    List<GroupMonthResult> selectConsumptionSumByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end,
            @Param("type") int type
    );

    /**
      * 查询某个groupid所对应的群体在某个时间段内在每个消费地点的消费所占的比例
      */
    List<GroupMonthResult> selectConsumptionRatioInDifferentPlacesByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    );

    /**
      * 查询某个群组下所有学生的学号、消费时间、消费地点
      */
    List<Map<String, Object>> selectSocialRelationDataFromXiaofeiByGroupAndTime(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("addr") String addr,
            @Param("start") String start,
            @Param("end") String end
    );

}