package com.cqupt.weigs.shirodemo.service;

import com.cqupt.weigs.shirodemo.common.Result;
import com.cqupt.weigs.shirodemo.entity.User;

import java.util.Set;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
public interface UserService {

    Result<User> findByUsername(String username);

    Set<String> findRoles(String username);

    /**
     * 根据用户名查找权限
     *
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    Result<String> insertUser(User user);
}
