package org.thealphalab.education.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.entity.GroupCourseResult;
import org.thealphalab.education.entity.GroupResult;
import org.thealphalab.education.model.Grade;

import java.util.List;
import java.util.Map;

@Repository
public interface GradeMapper {
    int deleteByPrimaryKey(@Param("stuid") Integer stuid, @Param("cid") String cid);

    int insert(Grade record);

    Grade selectByPrimaryKey(@Param("stuid") Integer stuid, @Param("cid") String cid);

    List<GroupResult> selectStudentCountByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_
    );

    /**
     * 根据学校、年级和起始考试日期计算挂科人数，并返回数据下一级的多条数据，
     * 比如school!=-1, class_=-1，则返回school内每一个class的数据。
     * 注：不要越级查找，比如school=300, year=-1, class_=国际软1402
     */
    List<Grade> selectAll();

    List<GroupResult> selectFailedCourseRatioByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end,
            @Param("course_type") int courseType
    );

    List<GroupCourseResult> selectFailedCourseRationByGroupIdAndCourseName(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end,
            @Param("course_type") int courseType
    );

    List<GroupResult> selectAvgGpaByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    );

    List<Integer> selectGradeEntropyByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    );

    List<Map<String, Object>> updateByPrimaryKey(
            @Param("stuid") String stuid,
            @Param("cid") String cid,
            @Param("gterm") String gterm
    );
}