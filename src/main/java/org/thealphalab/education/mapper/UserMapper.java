package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.User;

@Repository
public interface UserMapper {


    public User getUserByUsername(String username);

}
