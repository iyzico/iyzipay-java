package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionCustomerListResource {

    @SerializedName("items")
    private List<SubscriptionCustomerResponseResource> subscriptionCustomer;
    private Long totalCount;
    private Integer currentPage;
    private Integer pageCount;

    public List<SubscriptionCustomerResponseResource> getSubscriptionCustomer() {
        return subscriptionCustomer;
    }

    public void setSubscriptionCustomer(List<SubscriptionCustomerResponseResource> subscriptionCustomer) {
        this.subscriptionCustomer = subscriptionCustomer;
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
