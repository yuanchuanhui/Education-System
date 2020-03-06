package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Grade;
import org.thealphalab.education.model.Xiaofei;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public interface XiaofeiMapper {

    int insert(Xiaofei xiaofei) throws SQLIntegrityConstraintViolationException;
    int insertAll(List<Xiaofei> xiaofeis) throws SQLIntegrityConstraintViolationException;

}
