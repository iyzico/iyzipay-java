package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionProductListResource {

    @SerializedName("items")
    private List<SubscriptionProductResource> productList;
    private Long totalCount;
    private Integer currentPage;
    private Integer pageCount;

    public List<SubscriptionProductResource> getProductList() {
        return productList;
    }

    public void setProductList(List<SubscriptionProductResource> productList) {
        this.productList = productList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
