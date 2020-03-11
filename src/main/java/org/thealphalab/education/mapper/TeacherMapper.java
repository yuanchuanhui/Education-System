package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Teacher;

@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}