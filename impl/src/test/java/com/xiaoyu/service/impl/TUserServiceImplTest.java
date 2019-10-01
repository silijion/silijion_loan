package com.xiaoyu.service.impl;

import com.xiaoyu.BaseTest;
import com.xiaoyu.domain.PageInfo;
import com.xiaoyu.domain.PageResult;
import com.xiaoyu.domain.TUser;
import com.xiaoyu.service.TUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author shkstart@create 2019-09-25 23:42
 */

public class TUserServiceImplTest extends BaseTest {

    @Autowired
    private TUserService tUserService;

    @Test
    public void modifyTUser() {
        TUser tUser = new TUser();
        tUser.setId(18L);
        tUser.setUserid("好的");
        tUser.setUsername("合适的付款了黑色短裤");
        tUser.setUserage(100);
        tUserService.modifyTUser(tUser);

    }

    @Test
    public void queryTuser() {
        TUser tUser = new TUser();
        tUser.setUserid("张三");
        tUser.setUserpassword("uy2o34yu32");
        TUser tUser1 = tUserService.queryTuser(tUser);
        System.out.println(tUser1);
    }


    @Test
    public void accountPasswordQuery() throws Exception {
        TUser tUser = new TUser();
        tUser.setUserid("好的");
        tUser.setUserpassword("11232");
        tUserService.accountPasswordQuery(tUser);

    }

    @Test
    public void queryTUserByPage() {
        TUser tUser = new TUser();
//        tUser.setStatus(1);
        tUser.setUserid("laosiji");
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStart(6);
        pageInfo.setLimit(4);
        PageResult<TUser> tUserPageResult = tUserService.queryTUserByPage(tUser, pageInfo);
        List<TUser> rows = tUserPageResult.getRows();
        for (TUser row : rows) {
            System.out.println(row);
        }
        Integer total = tUserPageResult.getTotal();
        System.out.println(total);
    }
}
