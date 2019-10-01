package com.xiaoyu.service;

import com.xiaoyu.domain.PageInfo;
import com.xiaoyu.domain.PageResult;
import com.xiaoyu.domain.TUser;

import java.util.List;

/**
 * @author shkstart@create 2019-09-22 21:12
 */
public interface TUserService {

    /**
     * 注册
     * */
    public int registerTUser(TUser tUser) throws Exception;

    /**
     *修改用户
     * */
    public int modifyTUser(TUser tUser);

    /**
     * 查询用户
     * */
    public TUser queryTuser(TUser tUser);

    /**
     * 根据用户账号密码查询用户是否存在
     */
    public void accountPasswordQuery(TUser tUser) throws Exception;

    /**
     * 分页查询
     */
    public PageResult<TUser> queryTUserByPage(TUser tUser, PageInfo pageinfo);

}
