package com.baimax.hj.books.model;

import java.io.Serializable;

/**
 * Created by HJ on 2015/6/2.
 */
public class Tag implements Serializable{
    int count;
    String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
