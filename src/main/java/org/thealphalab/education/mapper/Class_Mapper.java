package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Class_;

@Repository
public interface Class_Mapper {
    int deleteByPrimaryKey(String classname);

    int insert(Class_ record);

    Class_ selectByPrimaryKey(String classname);

    List<Class_> selectAll();

    int updateByPrimaryKey(Class_ record);

    int insertAll(List<Class_> classList);
}