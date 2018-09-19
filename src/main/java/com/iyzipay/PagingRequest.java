package com.iyzipay;

public class PagingRequest extends Request {

    private Integer page;
    private Integer count;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("page", page)
                .append("count", count)
                .toString();
    }
}