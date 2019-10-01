package com.xiaoyu.service.impl;

import com.xiaoyu.BaseTest;
import com.xiaoyu.service.SequenceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shkstart@create 2019-09-25 21:07
 */

public class SequenceServiceImplTest extends BaseTest {

    @Autowired
    private SequenceService sequenceService;

    @Test
    public void generateIdentity() {
//        for (int i = 0; i <10 ; i++) {
//            Long seq_loan = sequenceService.generateIdentity("seq_loan");
//            System.out.println(seq_loan);
//        }

        Long seq_loan = sequenceService.generateIdentity("seq_loan");
        System.out.println(seq_loan);
    }
}
