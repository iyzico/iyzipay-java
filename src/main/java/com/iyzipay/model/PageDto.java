package com.iyzipay.model;

import java.util.List;

public class PageDto<T> {

    private List<T> items;
    private int page;
    private int size;
    private long total;

    public PageDto() {
    }

    public PageDto(List<T> items, int page, int size, long total) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public static <T> PageDto<T> of(List<T> items, int page, int size, long total) {
        return new PageDto<>(items, page, size, total);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}