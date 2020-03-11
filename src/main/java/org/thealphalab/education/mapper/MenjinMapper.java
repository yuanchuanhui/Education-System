package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Menjin;

@Repository
public interface MenjinMapper {
    int deleteByPrimaryKey(Integer mjid);

    int insert(Menjin record);

    Menjin selectByPrimaryKey(Integer mjid);

    List<Menjin> selectAll();

    int updateByPrimaryKey(Menjin record);
}