package com.xiaoyu.domain;

/**
 * @author shkstart@create 2019-09-26 18:58
 */
public class Result<T> {
    private Object object;
    private Boolean aBoolean;


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
