package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionData {

    private String referenceCode;
    private String parentReferenceCode;
    private String pricingPlanName;
    private String pricingPlanReferenceCode;
    private String productName;
    private String productReferenceCode;
    private String customerEmail;
    private String customerReferenceCode;
    private String customerGsmNumber;
    private Long paymentId;
    private String subscriptionStatus;
    private Integer trialDays;
    private String trialStartDate;
    private String trialEndDate;
    private String canceledAt;
    private String createdDate;
    private String startDate;
    private String endDate;
    @SerializedName(value = "orders")
    private List<SubscriptionOrderData> subscriptionOrders;

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

    public String getPricingPlanName() {
        return pricingPlanName;
    }

    public void setPricingPlanName(String pricingPlanName) {
        this.pricingPlanName = pricingPlanName;
    }

    public String getPricingPlanReferenceCode() {
        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {
        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductReferenceCode() {
        return productReferenceCode;
    }

    public void setProductReferenceCode(String productReferenceCode) {
        this.productReferenceCode = productReferenceCode;
    }

    public String getCustomerGsmNumber() {
        return customerGsmNumber;
    }

    public void setCustomerGsmNumber(String customerGsmNumber) {
        this.customerGsmNumber = customerGsmNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerReferenceCode() {
        return customerReferenceCode;
    }

    public void setCustomerReferenceCode(String customerReferenceCode) {
        this.customerReferenceCode = customerReferenceCode;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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

    public List<SubscriptionOrderData> getSubscriptionOrders() {
        return subscriptionOrders;
    }

    public void setSubscriptionOrders(List<SubscriptionOrderData> subscriptionOrders) {
        this.subscriptionOrders = subscriptionOrders;
    }
}
