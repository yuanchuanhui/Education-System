package org.thealphalab.education.mapper;

import org.springframework.stereotype.Repository;
import org.thealphalab.education.model.Role;

@Repository
public interface RoleMapper {

    /**
      * 通过角色Id获取角色对象。
      */
    public Role getRoleByRoleId(String roleId);

}
