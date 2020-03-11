package org.thealphalab.education.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Jieshu;

@Repository
public interface JieshuMapper {
    int deleteByPrimaryKey(@Param("stuid") Integer stuid, @Param("tsid") String tsid, @Param("jydate") Date jydate);

    int insert(Jieshu record);

    Jieshu selectByPrimaryKey(@Param("stuid") Integer stuid, @Param("tsid") String tsid, @Param("jydate") Date jydate);

    List<Jieshu> selectAll();

    int updateByPrimaryKey(Jieshu record);

    int insertAll(List<Jieshu> subList);
}