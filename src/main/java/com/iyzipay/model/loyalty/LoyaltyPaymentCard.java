package com.iyzipay.model.loyalty;

import com.iyzipay.ToStringRequestBuilder;

public class LoyaltyPaymentCard {
    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private String cardUserKey;
    private String cardToken;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("cardHolderName", cardHolderName)
                .append("cardNumber", cardNumber)
                .append("expireYear", expireYear)
                .append("expireMonth", expireMonth)
                .append("cvc", cvc)
                .append("cardUserKey", cardUserKey)
                .append("cardToken", cardToken)
                .toString();
    }
}
