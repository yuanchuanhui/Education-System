package org.thealphalab.education;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.service.RoleService;

@Controller
public class TestController {

    @Autowired
    private RoleService roleService;

//    @RequiresRoles("admin")
    @ResponseBody
    @RequestMapping("/test")
    @RequiresPermissions("5_2015_*")
    public String test(){
        return roleService.getRoleByRoleId(1).toString();
    }

}
