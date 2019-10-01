package com.xiaoyu.dao;

import com.xiaoyu.domain.TUser;

import java.util.List;

public interface TUserMapper {

    /**
     * 任何的表，都有3个操作
     * 新增，修改，查询
     * 如果页面需要分页查询，就加入分页查询。
     * 删除，进行逻辑删除，不进行物理删除。其实就是修改
     * */

    /**
     * 新增用户
     * @param tUser
     * @return
     */
    public int insertTUser(TUser tUser);


    /**
     * 修改用户
     */
    public int updateTUser(TUser tUser);

    /**
     * 查询单个
     */
    public TUser queryTUser(TUser tUser);

    /**
     *查询多个
     */
    public List<TUser> queryListTUser(TUser tUser);

    /**
     * 根据账号密码查询用户
     */
    public TUser queryUseridPassword(TUser tUser) throws Exception;


    /**
     * 分页查询
     */
    public List<TUser> queryTUserByPage(TUser tUser);


}