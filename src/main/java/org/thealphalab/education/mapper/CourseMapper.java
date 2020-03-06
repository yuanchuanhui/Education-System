package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Class_;
import org.thealphalab.education.model.Course;

import java.util.List;

@Repository
public interface CourseMapper {

    int insert(Course record);

}