package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.School;

@Repository
public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    School selectByPrimaryKey(Integer id);

    List<School> selectAll();

    int updateByPrimaryKey(School record);

    int insertAll(List<School> schoolList);
}