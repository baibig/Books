package com.baimax.hj.books.model;

import java.io.Serializable;

/**
 * Created by HJ on 2015/6/2.
 */
public class Images implements Serializable{
    String small;
    String large;
    String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
