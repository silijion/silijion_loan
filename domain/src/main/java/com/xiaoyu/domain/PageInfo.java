package com.xiaoyu.domain;

import java.io.Serializable;

/**
 * @author shkstart@create 2019-10-01 14:56
 */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 7293600095721337587L;

    //起始行
    private int start;

    //一页数据
    private int limit;

    private String searchText;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
