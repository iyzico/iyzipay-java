package com.iyzipay.request.subscription;

import com.iyzipay.model.subscription.resource.SubscriptionStatus;

import java.util.Date;

public class SearchSubscriptionRequest {

    private String subscriptionReferenceCode;
    private String parentReferenceCode;
    private String customerReferenceCode;
    private String pricingPlanReferenceCode;
    private SubscriptionStatus subscriptionStatus;
    private Date startDate;
    private Date endDate;

    public String getSubscriptionReferenceCode() {
        return subscriptionReferenceCode;
    }

    public void setSubscriptionReferenceCode(String subscriptionReferenceCode) {
        this.subscriptionReferenceCode = subscriptionReferenceCode;
    }

    public String getParentReferenceCode() {
        return parentReferenceCode;
    }

    public void setParentReferenceCode(String parentReferenceCode) {
        this.parentReferenceCode = parentReferenceCode;
    }

    public String getCustomerReferenceCode() {
        return customerReferenceCode;
    }

    public void setCustomerReferenceCode(String customerReferenceCode) {
        this.customerReferenceCode = customerReferenceCode;
    }

    public String getPricingPlanReferenceCode() {
        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {
        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
