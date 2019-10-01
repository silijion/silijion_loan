package com.xiaoyu.dao;

import com.xiaoyu.domain.Bankloanapplication;

public interface BankloanapplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bankloanapplication record);

    int insertSelective(Bankloanapplication record);

    Bankloanapplication selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bankloanapplication record);

    int updateByPrimaryKey(Bankloanapplication record);
}