package org.thealphalab.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thealphalab.education.mapper.UserMapper;
import org.thealphalab.education.mapper.UserRoleMapper;
import org.thealphalab.education.model.Role;
import org.thealphalab.education.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }

}
