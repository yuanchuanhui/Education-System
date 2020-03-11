package org.thealphalab.education.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Role;
import org.thealphalab.education.model.UserRole;

@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();

    Role selectRoleByUsername(String username);
}