package com.cqupt.weigs.shirodemo.dao;

import com.cqupt.weigs.shirodemo.entity.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}