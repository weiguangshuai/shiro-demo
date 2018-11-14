package com.cqupt.weigs.shirodemo.service;

import com.cqupt.weigs.shirodemo.entity.Role;

import java.util.Set;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
public interface RoleService {
    Set<String> findPermissions(Long[] roleIds);

    Role findRoleByRoleId(Long roleId);
}
