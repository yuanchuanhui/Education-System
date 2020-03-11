package org.thealphalab.education.model;

public class Role {
    private Integer roleid;

    private String rolename;

    private String permission;

    private String rolenamezh;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRolenamezh() {
        return rolenamezh;
    }

    public void setRolenamezh(String rolenamezh) {
        this.rolenamezh = rolenamezh;
    }
}