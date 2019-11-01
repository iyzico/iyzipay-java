package com.iyzipay.functional.builder;

import com.iyzipay.model.PaymentCard;

public final class PaymentCardBuilder {

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private Integer registerCard = 0;
    private String cardAlias;
    private String cardToken;
    private String cardUserKey;
    private String consumerToken;
    private boolean registerConsumerCard;
    private String ucsToken;

    private PaymentCardBuilder() {
    }

    public static PaymentCardBuilder create() {
        return new PaymentCardBuilder();
    }

    public PaymentCardBuilder cardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public PaymentCardBuilder cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public PaymentCardBuilder expireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public PaymentCardBuilder expireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
        return this;
    }

    public PaymentCardBuilder cvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public PaymentCardBuilder registerCard(Integer registerCard) {
        this.registerCard = registerCard;
        return this;
    }

    public PaymentCardBuilder cardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
        return this;
    }

    public PaymentCardBuilder cardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }

    public PaymentCardBuilder cardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
        return this;
    }

    public PaymentCardBuilder consumerToken(String consumerToken) {
        this.consumerToken = consumerToken;
        return this;
    }

    public PaymentCardBuilder registerConsumerCard(Boolean registerConsumerCard) {
        this.registerConsumerCard = registerConsumerCard;
        return this;
    }

    public PaymentCardBuilder ucsToken(String ucsToken) {
        this.ucsToken = ucsToken;
        return this;
    }

    public PaymentCard build() {
        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName(cardHolderName);
        paymentCard.setCardNumber(cardNumber);
        paymentCard.setExpireYear(expireYear);
        paymentCard.setExpireMonth(expireMonth);
        paymentCard.setCvc(cvc);
        paymentCard.setRegisterCard(registerCard);
        paymentCard.setCardAlias(cardAlias);
        paymentCard.setCardToken(cardToken);
        paymentCard.setCardUserKey(cardUserKey);
        paymentCard.setConsumerToken(consumerToken);
        paymentCard.setRegisterConsumerCard(registerConsumerCard);
        paymentCard.setUcsToken(ucsToken);
        return paymentCard;
    }

    public PaymentCardBuilder buildWithCardCredentials() {
        this.cardHolderName = "John Doe";
        this.cardNumber = "5528790000000008";
        this.expireYear = "2030";
        this.expireMonth = "12";
        this.cvc = "123";
        this.cardAlias = "card alias";
        return this;
    }
}
