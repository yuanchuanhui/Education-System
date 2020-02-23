package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thealphalab.education.mapper.RoleMapper;
import org.thealphalab.education.model.Role;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Role getRoleByRoleId(String roleId){
        return roleMapper.getRoleByRoleId(roleId);
    }

}
