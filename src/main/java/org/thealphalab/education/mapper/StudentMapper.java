package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Student;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    Student selectByPrimaryKey(Integer stuid);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}