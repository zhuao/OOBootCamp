package com.tw.bootcamp.bridge.domain;

import com.tw.bootcamp.bridge.CacheDataSource;

import java.util.Map;

public class Book {
    private String id;
    private String name;
    private final CacheDataSource cacheDataSource;


    public Book(String bookId) {
        this.id = bookId;
        this.cacheDataSource = new CacheDataSource();
    }

    public void getData() {
        Map<String, Object> document = cacheDataSource.getDocument();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
