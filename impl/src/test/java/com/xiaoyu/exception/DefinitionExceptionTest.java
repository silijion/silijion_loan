package com.xiaoyu.exception;

import com.xiaoyu.BaseTest;
import org.junit.Test;

/**
 * @author shkstart@create 2019-09-30 22:32
 */
public class DefinitionExceptionTest  {

    @Test
    public void test01() throws Exception{
        DefinitionException definitionException1 = new DefinitionException("", "数据下标越界", new ArrayIndexOutOfBoundsException());

        try {
            int i = 10;
            int a= i/0;
            System.out.println(a);
        } catch (Throwable e) {
            throw new DefinitionException("","出现错误了",e);
        }
    }


}
