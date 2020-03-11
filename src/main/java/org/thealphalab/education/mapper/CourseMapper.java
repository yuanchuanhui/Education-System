package org.thealphalab.education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Course;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(@Param("cid") String cid, @Param("cname") String cname);

    int insert(Course record);

    Course selectByPrimaryKey(@Param("cid") String cid, @Param("cname") String cname);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);
}