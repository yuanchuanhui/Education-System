package org.thealphalab.education.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Internetdata;

@Repository
public interface InternetdataMapper {
    int deleteByPrimaryKey(@Param("iaid") Integer iaid, @Param("stuid") Integer stuid, @Param("idstarttime") Date idstarttime);

    int insert(Internetdata record);

    Internetdata selectByPrimaryKey(@Param("iaid") Integer iaid, @Param("stuid") Integer stuid, @Param("idstarttime") Date idstarttime);

    List<Internetdata> selectAll();

    int updateByPrimaryKey(Internetdata record);
}