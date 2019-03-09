package com.ly.bigProject.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 1 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //过滤器设置
        /**
         *shiro 常用过滤器
         *  anon：无需认证（登录）
         *  authc：必须认证才可以访问（登录）
         *  user ：如果使用rememberMe功能可以直接访问
         *  perms：该资源必须得到角色权限才可以访问。
         *
         */
        Map<String,String> filterMap= new LinkedHashMap();
        filterMap.put("/test/tologin","anon");
        filterMap.put("/test/login","anon");

        filterMap.put("/test/*","authc");
      //  filterMap.put("/test/logout","logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        //修改默认无权跳转页面
        shiroFilterFactoryBean.setLoginUrl("/test/tologin");

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        return shiroFilterFactoryBean;


    }


    /**
     * 2 创建DefaultWebSecurityManger
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm
    ){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        return  securityManager;
    }

    /**
     * 3创建Realm
     */
    @Bean(name="UserRealm")
    public UserRealm getRealm(){

        return new UserRealm();
    }


}
