package org.thealphalab.education.model;

public class User {
    private String username;

    private String password;

    private String permission;

    private Boolean xflxdelsign;

    public User(String username) {
        this.username = username;
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

    public Boolean getXflxdelsign() {
        return xflxdelsign;
    }

    public void setXflxdelsign(Boolean xflxdelsign) {
        this.xflxdelsign = xflxdelsign;
    }
}