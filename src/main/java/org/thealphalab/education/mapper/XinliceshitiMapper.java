package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Xinliceshiti;

@Repository
public interface XinliceshitiMapper {
    int deleteByPrimaryKey(Integer xlcstmh);

    int insert(Xinliceshiti record);

    Xinliceshiti selectByPrimaryKey(Integer xlcstmh);

    List<Xinliceshiti> selectAll();

    int updateByPrimaryKey(Xinliceshiti record);
}