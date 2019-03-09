package com.ly.bigProject.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *
 */
public class UserRealm extends AuthorizingRealm {


    /**
     * 执行授权
     * @param principals
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权");
        return null;
    }

    /**
     * 执行认证
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
       // System.out.println("执行认证");
        String name="ly";
        String pwd="123456";

        UsernamePasswordToken token=(UsernamePasswordToken)arg0;
        // 1判断用户名
        if (!token.getUsername().equals(name)){
            //用户名不存在
            return null;
        }
        // 2判断密码
        return new SimpleAuthenticationInfo("",pwd,"");
    }
}
