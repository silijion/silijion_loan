package com.xiaoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiaoyu.common.Constant;
import com.xiaoyu.dao.TUserMapper;
import com.xiaoyu.domain.PageInfo;
import com.xiaoyu.domain.PageResult;
import com.xiaoyu.domain.TUser;
import com.xiaoyu.exception.DefinitionException;
import com.xiaoyu.exception.DefinitionFactory;
import com.xiaoyu.service.SequenceService;
import com.xiaoyu.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart@create 2019-09-22 21:25
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {


    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private SequenceService sequenceService;


    /**
     * 注册用户
     */
    @Override
    public int registerTUser(TUser tUser) throws Exception {
        tUser.setId(sequenceService.generateIdentity(Constant.SEQUENCE_LOAN));
        tUser.setStatus(Constant.DataStatus.VALID);
        tUser.setCreatebyid(tUser.getUserid());
        tUser.setCreatebyname(tUser.getUsername());
        tUser.setCreatetime(new Date());
        tUser.setUpdatebyid(tUser.getUserid());
        tUser.setUpdatebyname(tUser.getUsername());
        tUser.setUpdatetime(new Date());
        int i = tUserMapper.insertTUser(tUser);
        return i;
    }



    @Override
    public int modifyTUser(TUser tUser) {

        int i = tUserMapper.updateTUser(tUser);

        return i;
    }

    @Override
    public TUser queryTuser(TUser tUser) {
        TUser tUser1 = tUserMapper.queryTUser(tUser);
        return tUser1;
    }


    /*
    * 登陆校验
    * */
    @Override
    public void accountPasswordQuery(TUser tUser)  {
        //校验是否传入账号和密码
        if (tUser.getUserid().isEmpty()||tUser.getUserpassword().isEmpty()){
            throw DefinitionFactory.wrapException(DefinitionException.class,"", "账号和密码不能为空");
        }
        TUser querUser = new TUser();
        querUser.setUserid(tUser.getUserid());
        querUser = tUserMapper.queryTUser(tUser);
        if(querUser == null){
            throw DefinitionFactory.wrapException(DefinitionException.class,"", "账号不存在");
        }
        //判断是否存在 密码比较
        if(!tUser.getUserpassword().equals(querUser.getUserpassword())){
            //抛异常
            throw DefinitionFactory.wrapException(DefinitionException.class,"", "密码不正确");
        }

    }

    /**
     * 分页查询
     * @param tUser
     * @return
     */
    @Override
    public PageResult<TUser> queryTUserByPage(TUser tUser , PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getStart(), pageInfo.getLimit());
        List<TUser> tUsers = tUserMapper.queryTUserByPage(tUser);
        if (tUsers == null){
            throw DefinitionFactory.wrapException(DefinitionException.class,"","查询结果为空");
        }
        return new PageResult<>(tUsers.size(),tUsers);
    }


}
