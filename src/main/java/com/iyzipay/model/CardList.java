package com.iyzipay.model;

import com.iyzipay.IyzipayResource;

import java.util.List;

public class CardList extends IyzipayResource {

    private String cardUserKey;
    private List<Card> cardDetails;

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public List<Card> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(List<Card> cardDetails) {
        this.cardDetails = cardDetails;
    }
}
