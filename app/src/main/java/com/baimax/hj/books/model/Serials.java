package com.baimax.hj.books.model;

import java.io.Serializable;

/**
 * Created by HJ on 2015/6/2.
 */
public class Serials implements Serializable{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String id;
    String title;
}
