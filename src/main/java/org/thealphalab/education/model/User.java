package org.thealphalab.education.model;

public class User {

  private String username;
  private String password;
  private String permission;
  private boolean xflxdelsign;
  private Role role;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String username) {
    this.username = username;
  }

  public User(String username, String password, String permission) {
    this.username = username;
    this.password = password;
    this.permission = permission;
  }

  public User(String username, Role role) {
    this.username = username;
    this.role = role;
  }

  public User(String username, String password, String permission, boolean xflxdelsign) {
    this.username = username;
    this.password = password;
    this.permission = permission;
    this.xflxdelsign = xflxdelsign;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public boolean isXflxdelsign() {
    return xflxdelsign;
  }

  public void setXflxdelsign(boolean xflxdelsign) {
    this.xflxdelsign = xflxdelsign;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
