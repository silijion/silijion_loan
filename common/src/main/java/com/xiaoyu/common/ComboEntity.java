package com.xiaoyu.common;

/**
 * @author shkstart@create 2019-09-22 21:04
 */
public class ComboEntity {

    private String text;

    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ComboEntity(String text, String value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ComboEntity{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
