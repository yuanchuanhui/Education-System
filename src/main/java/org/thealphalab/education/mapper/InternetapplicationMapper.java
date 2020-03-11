package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Internetapplication;

@Repository
public interface InternetapplicationMapper {
    int deleteByPrimaryKey(Integer iaid);

    int insert(Internetapplication record);

    Internetapplication selectByPrimaryKey(Integer iaid);

    List<Internetapplication> selectAll();

    int updateByPrimaryKey(Internetapplication record);
}