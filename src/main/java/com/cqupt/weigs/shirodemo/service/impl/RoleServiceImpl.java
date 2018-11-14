package com.cqupt.weigs.shirodemo.service.impl;

import com.cqupt.weigs.shirodemo.dao.RoleMapper;
import com.cqupt.weigs.shirodemo.entity.Role;
import com.cqupt.weigs.shirodemo.service.ResourceService;
import com.cqupt.weigs.shirodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceService resourceService;

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<>();
        for (Long roleId : roleIds) {
            Role role = findRoleByRoleId(roleId);
            //所有角色拥有的资源
            if (role != null) {
                String[] resourceIdList = role.getResourceIds().split(",");
                for (String str : resourceIdList) {
                    resourceIds.add(Long.valueOf(str));
                }
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

    @Override
    public Role findRoleByRoleId(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
