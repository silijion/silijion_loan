package com.xiaoyu;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shkstart@create 2019-09-22 18:37
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "classpath*:test-applicationContext.xml" )
@Transactional
public class BaseTest {

}
