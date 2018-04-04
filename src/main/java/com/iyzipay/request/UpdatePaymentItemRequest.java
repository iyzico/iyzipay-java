package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class UpdatePaymentItemRequest extends Request {

    private String subMerchantKey;
    private Long paymentTransactionId;
    private BigDecimal subMerchantPrice;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public BigDecimal getSubMerchantPrice() {
        return subMerchantPrice;
    }

    public void setSubMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantKey", subMerchantKey)
                .append("paymentTransactionId", paymentTransactionId)
                .append("subMerchantPrice", subMerchantPrice)
                .toString();
    }
}