package com.xiaoyu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author shkstart@create 2019-10-01 15:00
 */
public class PageResult<E> implements Serializable {

    private static final long serialVersionUID = 2765333659627784766L;

    //总记录数
    private Integer total;

    //数据
    private List<E> rows;

    public PageResult(Integer total, List<E> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}
