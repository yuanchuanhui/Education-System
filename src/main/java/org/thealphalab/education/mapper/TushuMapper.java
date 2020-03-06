package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Tushu;
import org.thealphalab.education.model.Xiaofei;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public interface TushuMapper {

    int insert(Tushu tushu);
    int insertAll(List<Tushu> tushus) throws SQLIntegrityConstraintViolationException;

}
