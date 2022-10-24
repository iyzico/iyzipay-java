package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class RetrieveCardBlacklistRequest extends Request {
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("cardNumber", cardNumber)
                .toString();
    }
}
