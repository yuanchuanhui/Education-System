package org.thealphalab.education.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Xiaofei;

@Repository
public interface XiaofeiMapper {
    int deleteByPrimaryKey(Integer xfid);
    int deleteByStuid(Integer stuid);

    int insert(Xiaofei record);

    int insertAll(List<Xiaofei> xiaofeis);

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

    int updateByPrimaryKey(Xiaofei record);

}