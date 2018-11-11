package com.cqupt.weigs.shirodemo.dao;

import com.cqupt.weigs.shirodemo.entity.UserRoleKey;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}