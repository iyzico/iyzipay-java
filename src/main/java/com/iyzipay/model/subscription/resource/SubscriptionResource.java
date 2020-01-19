package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class SubscriptionResource {

    private String referenceCode;
    private String parentReferenceCode;
    private String pricingPlanName;
    private String pricingPlanReferenceCode;
    private String productName;
    private String productReferenceCode;
    private String customerEmail;
    private String customerReferenceCode;
    private Long paymentId;
    private String subscriptionStatus;
    private Integer trialDays;
    private Date trialStartDate;
    private Date trialEndDate;
    private Date canceledAt;
    private Date createdDate;
    private Date startDate;
    private Date endDate;
    @SerializedName(value = "orders")
    private List<SubscriptionOrderResource> subscriptionOrders;

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

    public Date getTrialStartDate() {
        return trialStartDate;
    }

    public void setTrialStartDate(Date trialStartDate) {
        this.trialStartDate = trialStartDate;
    }

    public Date getTrialEndDate() {
        return trialEndDate;
    }

    public void setTrialEndDate(Date trialEndDate) {
        this.trialEndDate = trialEndDate;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public List<SubscriptionOrderResource> getSubscriptionOrders() {
        return subscriptionOrders;
    }

    public void setSubscriptionOrders(List<SubscriptionOrderResource> subscriptionOrders) {
        this.subscriptionOrders = subscriptionOrders;
    }
}
