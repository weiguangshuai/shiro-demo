package com.cqupt.weigs.shirodemo.realm;

import com.cqupt.weigs.shirodemo.common.Result;
import com.cqupt.weigs.shirodemo.entity.User;
import com.cqupt.weigs.shirodemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <b><code>UserRealm</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/13 16:45.
 *
 * @author weigs
 * @since shrio-demo 2.0.0
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.findRoles(username));
        return null;
    }

    /**
     * 账号密码认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        Result<User> userResult = userService.findByUsername(username);

        if (!userResult.isSuccess()) {
            //没有找到账号
            throw new UnknownAccountException();
        }
        User user = userResult.getT();

        if (Boolean.TRUE.equals(user.getLocked())) {
            //账号被锁定
            throw new LockedAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，可以自定义实现
        return new SimpleAuthenticationInfo(user.getUsername(),
            user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
