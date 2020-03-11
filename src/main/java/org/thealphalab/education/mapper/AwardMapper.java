package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Award;

@Repository
public interface AwardMapper {
    int insert(Award record);

    List<Award> selectAll();
}