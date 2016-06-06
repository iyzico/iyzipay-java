package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class BkmInstallmentPrice {

    private Integer installmentNumber;
    private BigDecimal totalPrice;

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("installmentNumber", installmentNumber)
                .append("totalPrice", totalPrice)
                .toString();
    }
}
