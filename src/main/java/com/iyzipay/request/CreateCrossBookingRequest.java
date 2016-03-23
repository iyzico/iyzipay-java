package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class CreateCrossBookingRequest extends Request {

    private String subMerchantKey;
    private BigDecimal price;
    private String reason;
    private String currency;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantKey", subMerchantKey)
                .append("price", price)
                .append("reason", reason)
                .append("currency", currency)
                .toString();
    }
}