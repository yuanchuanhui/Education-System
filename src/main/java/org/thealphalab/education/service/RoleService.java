package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thealphalab.education.mapper.RoleMapper;
import org.thealphalab.education.mapper.UserRoleMapper;
import org.thealphalab.education.model.Role;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public Role getRoleByRoleId(int roleId){
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public Role getRoleByUsername(String username){
        return userRoleMapper.selectRoleByUsername(username);
    }

}
