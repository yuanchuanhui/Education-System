package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Role;

@Repository
public interface UserRoleMapper {

    public Role getRoleByUsername(String username);

}
