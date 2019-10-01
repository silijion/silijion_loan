package com.xiaoyu.domain;

import com.xiaoyu.common.ComboEntity;
import com.xiaoyu.common.Constant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author shkstart@create 2019-09-22 18:36
 */
public class TBankLoanAppServiceImplTest {


    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        List<ComboEntity> list = Constant.Gender.getList();
        for (ComboEntity comboEntity : list) {
            System.out.println(comboEntity);
        }
    }

    @Test
    public void insertSelective() {

    }


    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}
