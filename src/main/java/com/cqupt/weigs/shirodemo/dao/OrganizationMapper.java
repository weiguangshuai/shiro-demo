package com.cqupt.weigs.shirodemo.dao;

import com.cqupt.weigs.shirodemo.entity.Organization;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}