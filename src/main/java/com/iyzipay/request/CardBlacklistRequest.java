package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class CardBlacklistRequest extends Request {
    private String cardToken;
    private String cardUserKey;

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

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
                .append("cardToken", cardToken)
                .append("cardUserKey", cardUserKey)
                .toString();
    }
}
