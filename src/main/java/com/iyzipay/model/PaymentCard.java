package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

import java.util.Map;

public class PaymentCard {

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private Integer registerCard;
    private String cardAlias;
    private String cardToken;
    private String cardUserKey;
    private Map<String, String> metadata;
    private String consumerToken;
    private boolean registerConsumerCard;
    private String ucsToken;

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

    public Integer getRegisterCard() {
        return registerCard;
    }

    public void setRegisterCard(Integer registerCard) {
        this.registerCard = registerCard;
    }

    public String getCardAlias() {
        return cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
    }

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

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getConsumerToken() {
        return consumerToken;
    }

    public void setConsumerToken(String consumerToken) {
        this.consumerToken = consumerToken;
    }

    public boolean isRegisterConsumerCard() {
        return registerConsumerCard;
    }

    public void setRegisterConsumerCard(boolean registerConsumerCard) {
        this.registerConsumerCard = registerConsumerCard;
    }

    public String getUcsToken() {
        return ucsToken;
    }

    public void setUcsToken(String ucsToken) {
        this.ucsToken = ucsToken;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("cardHolderName", cardHolderName)
                .append("cardNumber", cardNumber)
                .append("expireYear", expireYear)
                .append("expireMonth", expireMonth)
                .append("cvc", cvc)
                .append("registerCard", registerCard)
                .append("cardAlias", cardAlias)
                .append("cardToken", cardToken)
                .append("cardUserKey", cardUserKey)
                .append("metadata", metadata)
                .append("consumerToken", consumerToken)
                .append("registerConsumerCard", registerConsumerCard)
                .append("ucsToken", ucsToken)
                .toString();
    }
}
