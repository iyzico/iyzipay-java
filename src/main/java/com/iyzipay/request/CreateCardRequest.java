package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.CardInformation;

public class CreateCardRequest extends Request {

    private String externalId;
    private String email;
    private String cardUserKey;
    private CardInformation card;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public CardInformation getCard() {
        return card;
    }

    public void setCard(CardInformation card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("externalId", externalId)
                .append("email", email)
                .append("cardUserKey", cardUserKey)
                .append("card", card)
                .toString();
    }
}
