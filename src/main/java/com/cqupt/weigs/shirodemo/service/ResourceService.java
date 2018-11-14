package com.cqupt.weigs.shirodemo.service;

import com.cqupt.weigs.shirodemo.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * @author weigs
 * @date 2018/11/14 0014
 */
public interface ResourceService {

    Resource findOne(Long resourceId);

    List<Resource> findAll();

    /**
     * 得到资源对应的权限字符串
     *
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     *
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);

}
