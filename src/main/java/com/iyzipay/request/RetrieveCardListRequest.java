package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class RetrieveCardListRequest extends Request {

    private String cardUserKey;

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("cardUserKey", cardUserKey)
                .toString();
    }
}
