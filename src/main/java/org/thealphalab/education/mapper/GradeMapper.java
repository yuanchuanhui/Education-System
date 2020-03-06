package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Grade;

@Repository
public interface GradeMapper {

    int insert(Grade grade);

}
