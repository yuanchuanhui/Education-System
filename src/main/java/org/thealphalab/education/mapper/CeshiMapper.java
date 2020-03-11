package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Ceshi;

@Repository
public interface CeshiMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(Ceshi record);

    Ceshi selectByPrimaryKey(Integer csid);

    List<Ceshi> selectAll();

    int updateByPrimaryKey(Ceshi record);
}