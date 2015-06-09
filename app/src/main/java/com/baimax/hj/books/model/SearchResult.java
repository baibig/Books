package com.baimax.hj.books.model;

import java.util.List;

/**
 * Created by HJ on 2015/6/2.
 */
public class SearchResult {
    int start;
    int count;
    int total;
    List<Book> books;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
