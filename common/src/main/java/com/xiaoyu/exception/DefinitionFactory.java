package com.xiaoyu.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author shkstart@create 2019-09-27 23:00
 * 异常类工厂
 */
public class DefinitionFactory {

    /**
     * 封装异常类的方法
     * @param exceptionClass
     * @param exceptionCode
     * @param exceptionMsg
     * @param cause
     * @return
     */
    public static DefinitionException wrapException(Class exceptionClass,String exceptionCode,String exceptionMsg,Throwable cause ){
        DefinitionException definitionException=null;

        try {
            //实例化异常类
            Constructor c1 = exceptionClass.getDeclaredConstructor(String.class, String.class, Throwable.class);
            Object exceptionobj = c1.newInstance(exceptionCode, exceptionMsg, cause);
            //将异常类转换成基类
            if(exceptionobj instanceof DefinitionException){
                definitionException = (DefinitionException) exceptionobj;
            }else {
                try {
                    definitionException = new DefinitionException("", "传入的异常类不是DefinitionException的子类", cause);
                }catch (Throwable e){
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return definitionException;
    }

    /**
     * 封装异常类的方法
     * @param exceptionClass
     * @param exceptionCode
     * @param exceptionMsg
     * @return
     */
    public static DefinitionException wrapException(Class exceptionClass,String exceptionCode,String exceptionMsg ) {
        DefinitionException definitionException = null;
        try {
            //实例化异常类
            Constructor c1 = exceptionClass.getDeclaredConstructor(String.class, String.class );
            Object exceptionobj = c1.newInstance(exceptionCode, exceptionMsg);
            //将异常类转换成基类
            if (exceptionobj instanceof DefinitionException) {
                definitionException = (DefinitionException) exceptionobj;
            } else {
                try {
                    definitionException = new DefinitionException("", "传入的异常类不是DefinitionException的子类");
                } catch (Throwable e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return definitionException;

    }
}