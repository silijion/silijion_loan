package com.xiaoyu.domain;

/**
 * @author shkstart@create 2019-10-01 0:05
 */
public class AjaxMessageEntity<T> {

    //返回码
    private int code = 0;

    //返回状态
    private String msg = "ok";

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessager(int code ,String msg){
        this.code = code;
        this.msg = msg;
    }
}
