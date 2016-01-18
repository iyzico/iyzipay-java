package com.iyzipay.model;

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
}
