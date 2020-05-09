package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionSearchListData {

    @SerializedName("items")
    private List<SubscriptionData> subscription;
    private Long totalCount;
    private Integer currentPage;
    private Integer pageCount;

    public List<SubscriptionData> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<SubscriptionData> subscription) {
        this.subscription = subscription;
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
