package com.iyzipay.model.subscription.resource;

public class SubscriptionUpgradeData {

    private String referenceCode;
    private String parentReferenceCode;
    private String pricingPlanReferenceCode;
    private String customerReferenceCode;
    private String subscriptionStatus;
    private Integer trialDays;
    private String trialStartDate;
    private String trialEndDate;
    private String canceledAt;
    private String createdDate;
    private String startDate;
    private String endDate;

    public String getReferenceCode() {

        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {

        this.referenceCode = referenceCode;
    }

    public String getParentReferenceCode() {

        return parentReferenceCode;
    }

    public void setParentReferenceCode(String parentReferenceCode) {

        this.parentReferenceCode = parentReferenceCode;
    }

    public String getPricingPlanReferenceCode() {

        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {

        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }

    public String getCustomerReferenceCode() {

        return customerReferenceCode;
    }

    public void setCustomerReferenceCode(String customerReferenceCode) {

        this.customerReferenceCode = customerReferenceCode;
    }

    public String getSubscriptionStatus() {

        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {

        this.subscriptionStatus = subscriptionStatus;
    }

    public Integer getTrialDays() {

        return trialDays;
    }

    public void setTrialDays(Integer trialDays) {

        this.trialDays = trialDays;
    }

    public String getTrialStartDate() {

        return trialStartDate;
    }

    public void setTrialStartDate(String trialStartDate) {

        this.trialStartDate = trialStartDate;
    }

    public String getTrialEndDate() {

        return trialEndDate;
    }

    public void setTrialEndDate(String trialEndDate) {

        this.trialEndDate = trialEndDate;
    }

    public String getCanceledAt() {

        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {

        this.canceledAt = canceledAt;
    }

    public String getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(String createdDate) {

        this.createdDate = createdDate;
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
