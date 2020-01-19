package com.iyzipay.request.subscription;

import com.iyzipay.Request;

import java.math.BigDecimal;

public class CreateSubscriptionPricingPlanRequest extends Request {

    private String name;
    private BigDecimal price;
    private String currencyCode;
    private String paymentInterval;
    private Integer paymentIntervalCount;
    private Integer trialPeriodDays;
    private String planPaymentType;
    private Integer recurrenceCount;

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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public String getPlanPaymentType() {
        return planPaymentType;
    }

    public void setPlanPaymentType(String planPaymentType) {
        this.planPaymentType = planPaymentType;
    }

    public Integer getRecurrenceCount() {
        return recurrenceCount;
    }

    public void setRecurrenceCount(Integer recurrenceCount) {
        this.recurrenceCount = recurrenceCount;
    }
}
