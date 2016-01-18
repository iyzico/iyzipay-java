package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class InstallmentPrice {

    private BigDecimal installmentPrice;
    private BigDecimal totalPrice;
    private Integer installmentNumber;

    public BigDecimal getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(BigDecimal installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
