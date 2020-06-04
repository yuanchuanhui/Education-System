package org.thealphalab.education.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Jieshu;

@Repository
public interface JieshuMapper {
    int deleteByPrimaryKey(@Param("stuid") Integer stuid, @Param("tsid") String tsid, @Param("jydate") Date jydate);

    int insert(Jieshu record);

    Jieshu selectByPrimaryKey(@Param("stuid") Integer stuid, @Param("tsid") String tsid, @Param("jydate") Date jydate);

    List<Jieshu> selectAll();
    List<String> selectAllTushuNameNotEmptyByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    );
    List<Map<String, Object>> selectTsnameAndNumByGroupId(
            @Param("school") int school,
            @Param("year") int year,
            @Param("class_") String class_,
            @Param("start") String start,
            @Param("end") String end
    );

    int updateByPrimaryKey(Jieshu record);

    int insertAll(List<Jieshu> subList);
}