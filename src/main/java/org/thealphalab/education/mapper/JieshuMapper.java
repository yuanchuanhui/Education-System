package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Jieshu;
import org.thealphalab.education.model.Tushu;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public interface JieshuMapper {

    int insert(Jieshu jieshu) throws SQLIntegrityConstraintViolationException;
    int insertAll(List<Jieshu> jieshus) throws SQLIntegrityConstraintViolationException;

}
