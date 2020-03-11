package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Social;

@Repository
public interface SocialMapper {
    int insert(Social record);

    List<Social> selectAll();
}