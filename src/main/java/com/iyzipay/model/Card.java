package com.iyzipay.model;

import java.util.Map;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.DeleteCardRequest;

public class Card extends IyzipayResource {

    private String externalId;
    private String email;
    private String cardUserKey;
    private String cardToken;
    private String cardAlias;
    private String binNumber;
    private String lastFourDigits;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private Long cardBankCode;
    private String cardBankName;
    private String cardHolderName;
    private String expireMonth;
    private String expireYear;
    private Map<String, String> metadata;

    public static Card create(CreateCardRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/cardstorage/card",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Card.class);
    }

    public static Card delete(DeleteCardRequest request, Options options) {
        return HttpClient.create().delete(options.getBaseUrl() + "/cardstorage/card",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Card.class);
    }

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

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getCardAlias() {
        return cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardAssociation() {
        return cardAssociation;
    }

    public void setCardAssociation(String cardAssociation) {
        this.cardAssociation = cardAssociation;
    }

    public String getCardFamily() {
        return cardFamily;
    }

    public void setCardFamily(String cardFamily) {
        this.cardFamily = cardFamily;
    }

    public Long getCardBankCode() {
        return cardBankCode;
    }

    public void setCardBankCode(Long cardBankCode) {
        this.cardBankCode = cardBankCode;
    }

    public String getCardBankName() {
        return cardBankName;
    }

    public void setCardBankName(String cardBankName) {
        this.cardBankName = cardBankName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
