package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SubscriptionOrderResource {

    private String referenceCode;
    private BigDecimal price;
    private String currencyCode;
    private Date startPeriod;
    private Date endPeriod;
    private SubscriptionOrderStatus orderStatus;
    @SerializedName(value = "paymentAttempts")
    private List<SubscriptionOrderPaymentAttemptResource> orderPaymentAttempts;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
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

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public SubscriptionOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(SubscriptionOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<SubscriptionOrderPaymentAttemptResource> getOrderPaymentAttempts() {
        return orderPaymentAttempts;
    }

    public void setOrderPaymentAttempts(List<SubscriptionOrderPaymentAttemptResource> orderPaymentAttempts) {
        this.orderPaymentAttempts = orderPaymentAttempts;
    }
}
