package com.iyzipay.model.loyalty;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class LoyaltyInquireRequest extends Request {
    private LoyaltyPaymentCard paymentCard;
    private String currency;

    public LoyaltyPaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(LoyaltyPaymentCard paymentCard) {
        this.paymentCard = paymentCard;
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
                .append("paymentCard", paymentCard)
                .append("currency", currency)
                .toString();

    }
}