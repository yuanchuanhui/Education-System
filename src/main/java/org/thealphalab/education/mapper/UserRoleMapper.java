package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Role;

import java.util.List;

@Repository
public interface UserRoleMapper {

    public List<Role> getRolesByUsername(String username);

}
