package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionPricingPlanListData {

    @SerializedName("items")
    private List<SubscriptionPricingPlanData> subscriptionPricingPlansResource;
    private Long totalCount;
    private Integer currentPage;
    private Integer pageCount;

    public List<SubscriptionPricingPlanData> getSubscriptionPricingPlansResource() {
        return subscriptionPricingPlansResource;
    }

    public void setSubscriptionPricingPlansResource(List<SubscriptionPricingPlanData> subscriptionPricingPlansResource) {
        this.subscriptionPricingPlansResource = subscriptionPricingPlansResource;
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
