package com.iyzipay.functional.builder;

import com.iyzipay.model.CardInformation;

public final class CardInformationBuilder {

    private String cardAlias = "card alias";
    private String cardNumber = "5528790000000008";
    private String expireYear = "2030";
    private String expireMonth = "12";
    private String cardHolderName = "John Doe";

    private CardInformationBuilder() {
    }

    public static CardInformationBuilder create() {
        return new CardInformationBuilder();
    }

    public CardInformationBuilder cardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
        return this;
    }

    public CardInformationBuilder cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CardInformationBuilder expireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public CardInformationBuilder expireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
        return this;
    }

    public CardInformationBuilder cardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public CardInformation build() {
        CardInformation cardInformation = new CardInformation();
        cardInformation.setCardAlias(cardAlias);
        cardInformation.setCardNumber(cardNumber);
        cardInformation.setExpireYear(expireYear);
        cardInformation.setExpireMonth(expireMonth);
        cardInformation.setCardHolderName(cardHolderName);
        return cardInformation;
    }
}
