package com.cqupt.weigs.shirodemo.service.impl;

import com.cqupt.weigs.shirodemo.common.Result;
import com.cqupt.weigs.shirodemo.dao.RoleMapper;
import com.cqupt.weigs.shirodemo.dao.UserMapper;
import com.cqupt.weigs.shirodemo.entity.Role;
import com.cqupt.weigs.shirodemo.entity.User;
import com.cqupt.weigs.shirodemo.service.RoleService;
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

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

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
        Set<String> rolesSet = new HashSet<>();
        if (rolesId != null) {
            String[] roleIdList = rolesId.split(",");
            for (String roleId : roleIdList) {
                Role role = roleMapper.selectByPrimaryKey(Long.valueOf(roleId));
                rolesSet.add(role.getRole());
            }
        }
        return rolesSet;
    }

    @Override
    public Set<String> findPermissions(String username) {
        User user = findByUsername(username).getT();
        Set<Long> roleId = new HashSet<>();
        for (String str : user.getRoleIds().split(",")) {
            roleId.add(Long.valueOf(str));
        }
        return roleService.findPermissions(roleId.toArray(new Long[0]));
    }
}
