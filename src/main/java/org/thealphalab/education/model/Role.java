package com.sample;


public class Role {

  private long roleId;
  private String roleName;
  private String permission;
  private String roleNameZh;


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }


  public String getRoleNameZh() {
    return roleNameZh;
  }

  public void setRoleNameZh(String roleNameZh) {
    this.roleNameZh = roleNameZh;
  }

}
