package com.cqupt.weigs.shirodemo;

import com.cqupt.weigs.shirodemo.credentials.RetryLimitHashCredentialsMatcher;
import com.cqupt.weigs.shirodemo.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b><code>ShiroConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/13 17:02.
 *
 * @author weigs
 * @since shrio-demo 2.0.0
 */
@Configuration
public class ShiroConfig {

    private static final long GLOBAL_SESSION_TIMEOUT = 180 * 1000;

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
//        userRealm.setCredentialsMatcher(retryLimitHashCredentialsMatcher());
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    public RetryLimitHashCredentialsMatcher retryLimitHashCredentialsMatcher() {
        return new RetryLimitHashCredentialsMatcher();
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //md5加密1次
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    @Bean
    public SessionManager shiroSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(GLOBAL_SESSION_TIMEOUT);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager shiroSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(shiroSessionManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/admin/index", "anon");
        filterChainDefinitionMap.put("/admin/weigs", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }
}
