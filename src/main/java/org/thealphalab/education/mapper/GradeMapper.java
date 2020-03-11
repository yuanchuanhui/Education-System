package org.thealphalab.education.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Grade;

@Repository
public interface GradeMapper {
    int deleteByPrimaryKey(@Param("stuid") Integer stuid, @Param("cid") String cid);

    int insert(Grade record);

    Grade selectByPrimaryKey(@Param("stuid") Integer stuid, @Param("cid") String cid);
    List<Map<String, Integer>> selectRequireCourseFailedNumInDiffClassBySchoolId(int stuschool, int year);
    List<Map<String, Integer>> selectRequireCourseFailedNumInDiffYearBySchoolId(int stuschool);
    List<Map<String, Integer>> selectStudentCount(int stuschool, int year, int stuclass);

    List<Grade> selectAll();

    int updateByPrimaryKey(Grade record);
}