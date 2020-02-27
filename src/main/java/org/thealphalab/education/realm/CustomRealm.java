package org.thealphalab.education.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.thealphalab.education.model.Role;
import org.thealphalab.education.model.User;
import org.thealphalab.education.service.RoleService;
import org.thealphalab.education.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
  * 自定义Realm，在shiro中，Realm用于从数据库中查询得到用户的登陆和授权信息。
  */
public class CustomRealm extends AuthorizingRealm {

    private final static String REALM_NAME = "customRealm";

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
      * 从数据库中获取该用户的授权信息，用于接下来的授权操作。
      */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User user = userService.getUserByUsername(username);
        Set<String> permissions = new HashSet<>(1);
        permissions.add(user.getPermission());
        authorizationInfo.setStringPermissions(permissions);

        Role role = roleService.getRoleByUsername(username);
        Set<String> roles = new HashSet<>();
        roles.add(role.getRoleName());
        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }

    /**
      * 从数据库中查询用户信息（如密码），用于接下来的认证操作。
      */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.getUserByUsername(username);
        if(user != null){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
            SimplePrincipalCollection collection = new SimplePrincipalCollection();
            collection.add(user.getUsername(), CustomRealm.REALM_NAME);
            authenticationInfo.setPrincipals(collection);
            authenticationInfo.setCredentials(user.getPassword());
            return authenticationInfo;
        }else {
            throw new AuthenticationException();
        }
    }

    /**
      * 判断当前用户是否有权限做某事，在本系统中，用于判断一名老师是否有权限访问某一批学生。
      */
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        AuthorizationInfo info = getAuthorizationInfo(principals);
        String[] requireArr = permission.split("_");
        String requirePermission = info.getStringPermissions().iterator().next();
        String[] userArr = requirePermission.split("_");
        for (int i = 0; i < 3; i++) {
            if(!(userArr[i].equals("*") || requireArr[i].equals(userArr[i]))){
                return false;
            }
        }
        return true;
    }

}
