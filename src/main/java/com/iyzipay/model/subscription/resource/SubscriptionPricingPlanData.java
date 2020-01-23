package com.iyzipay.model.subscription.resource;

import java.math.BigDecimal;

public class SubscriptionPricingPlanData {

    private String referenceCode;
    private String createdDate;
    private String name;
    private BigDecimal price;
    private String paymentInterval;
    private Integer paymentIntervalCount;
    private Integer trialPeriodDays;
    private String currencyCode;
    private String productReferenceCode;
    private String planPaymentType;
    private String status;
    private Integer recurrenceCount;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(String paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    public Integer getPaymentIntervalCount() {
        return paymentIntervalCount;
    }

    public void setPaymentIntervalCount(Integer paymentIntervalCount) {
        this.paymentIntervalCount = paymentIntervalCount;
    }

    public Integer getTrialPeriodDays() {
        return trialPeriodDays;
    }

    public void setTrialPeriodDays(Integer trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getProductReferenceCode() {
        return productReferenceCode;
    }

    public void setProductReferenceCode(String productReferenceCode) {
        this.productReferenceCode = productReferenceCode;
    }

    public String getPlanPaymentType() {
        return planPaymentType;
    }

    public void setPlanPaymentType(String planPaymentType) {
        this.planPaymentType = planPaymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRecurrenceCount() {
        return recurrenceCount;
    }

    public void setRecurrenceCount(Integer recurrenceCount) {
        this.recurrenceCount = recurrenceCount;
    }
}
