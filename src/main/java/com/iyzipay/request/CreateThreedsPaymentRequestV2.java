package com.iyzipay.request;

import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class CreateThreedsPaymentRequestV2 extends CreateThreedsPaymentRequest {

    private String basketId;
    private BigDecimal paidPrice;
    private String currency;

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
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
                .append("basketId", basketId)
                .append("paidPrice", paidPrice)
                .append("currency", currency)
                .toString();
    }
}
