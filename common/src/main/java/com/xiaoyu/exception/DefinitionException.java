package com.xiaoyu.exception;

/**
 * @author shkstart@create 2019-09-27 20:52
 */
public class DefinitionException extends RuntimeException{


    /**
     * 异常编码
     */
    private String exceptionCode;

    /**
     * 异常信息
     */
    private String exceptionMsg;


    public DefinitionException(String exceptionCode, String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }


    public DefinitionException(String exceptionCode, String exceptionMsg, Throwable throwable ) {
        super(exceptionMsg,throwable);
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }


    public String getExceptionMsg() {
        return exceptionMsg;
    }


}
