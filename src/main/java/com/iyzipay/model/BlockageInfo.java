package com.iyzipay.model;

import com.iyzipay.IyzipayResource;

import java.math.BigDecimal;

public class BlockageInfo extends IyzipayResource {

    private BigDecimal usableBlockage;
    private BigDecimal totalBlockage;
    private BigDecimal totalBalance;

    public BigDecimal getUsableBlockage() {
        return usableBlockage;
    }

    public void setUsableBlockage(BigDecimal usableBlockage) {
        this.usableBlockage = usableBlockage;
    }

    public BigDecimal getTotalBlockage() {
        return totalBlockage;
    }

    public void setTotalBlockage(BigDecimal totalBlockage) {
        this.totalBlockage = totalBlockage;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }
}
