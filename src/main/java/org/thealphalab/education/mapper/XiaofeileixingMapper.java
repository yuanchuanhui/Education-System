package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Xiaofeileixing;

@Repository
public interface XiaofeileixingMapper {
    int deleteByPrimaryKey(Integer xflxid);

    int insert(Xiaofeileixing record);

    Xiaofeileixing selectByPrimaryKey(Integer xflxid);

    List<Xiaofeileixing> selectAll();

    int updateByPrimaryKey(Xiaofeileixing record);
}