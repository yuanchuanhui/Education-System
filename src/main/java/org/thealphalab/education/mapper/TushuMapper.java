package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Tushu;

@Repository
public interface TushuMapper {
    int deleteByPrimaryKey(String tsid);

    int insert(Tushu record);

    Tushu selectByPrimaryKey(String tsid);

    List<Tushu> selectAll();

    int updateByPrimaryKey(Tushu record);

    int insertAll(List<Tushu> subList);
}