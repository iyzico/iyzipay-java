package com.iyzipay.request.subscription;

public class SearchSubscriptionRequest {

    private String subscriptionReferenceCode;
    private String parentReferenceCode;
    private String customerReferenceCode;
    private String pricingPlanReferenceCode;
    private String subscriptionStatus;
    private String startDate;
    private String endDate;

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

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
