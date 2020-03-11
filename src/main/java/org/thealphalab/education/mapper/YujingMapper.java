package org.thealphalab.education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Yujing;

@Repository
public interface YujingMapper {
    int deleteByPrimaryKey(@Param("stuid") Integer stuid, @Param("yjsort") String yjsort);

    int insert(Yujing record);

    Yujing selectByPrimaryKey(@Param("stuid") Integer stuid, @Param("yjsort") String yjsort);

    List<Yujing> selectAll();

    int updateByPrimaryKey(Yujing record);
}