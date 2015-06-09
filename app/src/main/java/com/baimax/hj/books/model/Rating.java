package com.baimax.hj.books.model;

import java.io.Serializable;

/**
 * Created by HJ on 2015/6/2.
 */
public class Rating implements Serializable{
    int max;
    int numRaters;
    float average;
    int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
