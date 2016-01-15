package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.DeleteCardRequest;
import com.iyzipay.request.RetrieveCardRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Card extends IyzipayResource {

    private String externalId;
    private String email;
    private String cardUserKey;
    private String cardToken;
    private String cardAlias;
    private String binNumber;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private Long cardBankCode;
    private String cardBankName;

    public static Card create(CreateCardRequest request, Options options) {
        return HttpClient.create().
                post(options.getBaseUrl() + "/cardstorage/card",
                        getHttpHeaders(request, options),
                        request,
                        Card.class)
                .getBody();
    }

    public static Card delete(DeleteCardRequest request, Options options) {
        return HttpClient.create().
                delete(options.getBaseUrl() + "/cardstorage/card",
                        getHttpHeaders(request, options),
                        request,
                        Card.class)
                .getBody();
    }

    public static CardList retrieve(RetrieveCardRequest request, Options options) {
        return HttpClient.create().
                post(options.getBaseUrl() + "/cardstorage/cards",
                        getHttpHeaders(request, options),
                        request,
                        CardList.class)
                .getBody();
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
