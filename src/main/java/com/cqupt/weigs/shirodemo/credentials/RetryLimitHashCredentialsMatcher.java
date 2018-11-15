package com.cqupt.weigs.shirodemo.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weigs
 * @date 2018/11/15 0015
 */
public class RetryLimitHashCredentialsMatcher extends HashedCredentialsMatcher {

    private Map<String, Integer> passwordRetryCache = new ConcurrentHashMap<>();

    /**
     * 重新定义认证函数，添加错误五次不能登录的功能
     *
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        //如果相应的username获取到的integer为null，则设置为0
        passwordRetryCache.putIfAbsent(username, 0);
        if ((passwordRetryCache.get(username) + 1) > 5) {
            throw new ExcessiveAttemptsException("账号已经锁定，请更改密码后重新登录");
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
