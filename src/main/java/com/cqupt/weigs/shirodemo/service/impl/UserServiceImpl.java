package com.cqupt.weigs.shirodemo.service.impl;

import com.cqupt.weigs.shirodemo.common.Result;
import com.cqupt.weigs.shirodemo.dao.UserMapper;
import com.cqupt.weigs.shirodemo.entity.User;
import com.cqupt.weigs.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> findByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("未找到用户");
    }

    @Override
    public Set<String> findRoles(String username) {
        String rolesId = userMapper.selectRolesByUsername(username);
        if (rolesId != null) {
            Set<Long> rolesSet = new HashSet<>();
            String[] roleList = rolesId.split(",");
            for (String role : roleList) {

            }

        }
        return null;
    }
}
