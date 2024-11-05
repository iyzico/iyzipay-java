package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class UpdatePaymentItemRequest extends Request {

    private String subMerchantKey;
    private String externalSubMerchantId;

    private Long paymentTransactionId;
    private BigDecimal subMerchantPrice;
    private boolean crossBookingOperation;
    private BigDecimal chargedPriceFromMerchant;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public String getExternalSubMerchantId() {
        return externalSubMerchantId;
    }

    public void setExternalSubMerchantId(String externalSubMerchantId) {
        this.externalSubMerchantId = externalSubMerchantId;
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

    public boolean isCrossBookingOperation() {
        return crossBookingOperation;
    }

    public void setCrossBookingOperation(boolean crossBookingOperation) {
        this.crossBookingOperation = crossBookingOperation;
    }

    public BigDecimal getChargedPriceFromMerchant() {
        return chargedPriceFromMerchant;
    }

    public void setChargedPriceFromMerchant(BigDecimal chargedPriceFromMerchant) {
        this.chargedPriceFromMerchant = chargedPriceFromMerchant;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("subMerchantKey", subMerchantKey)
                .append("externalSubMerchantId", externalSubMerchantId)
                .append("paymentTransactionId", paymentTransactionId)
                .append("subMerchantPrice", subMerchantPrice)
                .toString();
    }
}