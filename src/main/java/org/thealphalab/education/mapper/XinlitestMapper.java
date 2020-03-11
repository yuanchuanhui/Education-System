package org.thealphalab.education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Xinlitest;

@Repository
public interface XinlitestMapper {
    int deleteByPrimaryKey(@Param("csid") Integer csid, @Param("stuid") Integer stuid);

    int insert(Xinlitest record);

    List<Xinlitest> selectAll();
}