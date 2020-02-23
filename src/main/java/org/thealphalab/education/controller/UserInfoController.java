package org.thealphalab.education.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.RespBean;
import org.thealphalab.education.mapper.UserRoleMapper;
import org.thealphalab.education.model.Role;
import org.thealphalab.education.model.User;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
      * 返回当前登陆用户的信息，可能同时很多页面需要访问该方法。
      */
    @GetMapping("/userInfo")
    @RequiresUser
    @ResponseBody
    public String userInfo() throws JsonProcessingException {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        RespBean respBean = new RespBean("userInfo");
        respBean.setStatus(0);
        List<Role> roles = userRoleMapper.getRolesByUsername(username);
        User user = new User(username, roles);
        respBean.setObj(user);
        return new ObjectMapper().writeValueAsString(respBean);
    }

}
