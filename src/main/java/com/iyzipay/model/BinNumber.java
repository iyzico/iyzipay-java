package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveBinNumberRequest;

public class BinNumber extends IyzipayResource {

    private String binNumber;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private String bankName;
    private Long bankCode;
    private Integer commercial;

    public static BinNumber retrieve(RetrieveBinNumberRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/bin/check",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BinNumber.class);
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getCommercial() {
        return commercial;
    }

    public void setCommercial(Integer commercial) {
        this.commercial = commercial;
    }
}
