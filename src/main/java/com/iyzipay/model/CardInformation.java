package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

public class CardInformation {

    private String cardAlias;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cardHolderName;

    public String getCardAlias() {
        return cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("cardAlias", cardAlias)
                .append("cardNumber", cardNumber)
                .append("expireYear", expireYear)
                .append("expireMonth", expireMonth)
                .append("cardHolderName", cardHolderName)
                .toString();
    }
}
