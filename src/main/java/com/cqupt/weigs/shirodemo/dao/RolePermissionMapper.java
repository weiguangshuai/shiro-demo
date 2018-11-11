package com.cqupt.weigs.shirodemo.dao;

import com.cqupt.weigs.shirodemo.entity.RolePermissionKey;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);
}