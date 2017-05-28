package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class InstallmentDetail {

    private String binNumber;
    private BigDecimal price;
    private String cardType;
    private String cardAssociation;
    private String cardFamilyName;
    private Integer force3ds;
    private Long bankCode;
    private String bankName;
    private Integer forceCvc;
    private Integer commercial;
    private List<InstallmentPrice> installmentPrices;

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getCardFamilyName() {
        return cardFamilyName;
    }

    public void setCardFamilyName(String cardFamilyName) {
        this.cardFamilyName = cardFamilyName;
    }

    public Integer getForce3ds() {
        return force3ds;
    }

    public void setForce3ds(Integer force3ds) {
        this.force3ds = force3ds;
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getForceCvc() {
        return forceCvc;
    }

    public void setForceCvc(Integer forceCvc) {
        this.forceCvc = forceCvc;
    }

    public Integer getCommercial() {
        return commercial;
    }

    public void setCommercial(Integer commercial) {
        this.commercial = commercial;
    }

    public List<InstallmentPrice> getInstallmentPrices() {
        return installmentPrices;
    }

    public void setInstallmentPrices(List<InstallmentPrice> installmentPrices) {
        this.installmentPrices = installmentPrices;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
