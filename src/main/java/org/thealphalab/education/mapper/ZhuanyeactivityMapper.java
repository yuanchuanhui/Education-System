package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Zhuanyeactivity;

@Repository
public interface ZhuanyeactivityMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Zhuanyeactivity record);

    Zhuanyeactivity selectByPrimaryKey(Integer aid);

    List<Zhuanyeactivity> selectAll();

    int updateByPrimaryKey(Zhuanyeactivity record);
}