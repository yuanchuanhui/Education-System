package org.thealphalab.education.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.User;

@Repository
public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

    User selectUserByUsername(String username);

    int updateByPrimaryKey(User record);
}