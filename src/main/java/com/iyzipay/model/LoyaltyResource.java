package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class LoyaltyResource extends IyzipayResource {

    private BigDecimal points;
    private BigDecimal amount;
    private String cardBank;
    private String cardFamily;
    private String currency;

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public String getCardFamily() {
        return cardFamily;
    }

    public void setCardFamily(String cardFamily) {
        this.cardFamily = cardFamily;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
