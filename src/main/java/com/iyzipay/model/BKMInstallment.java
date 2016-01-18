package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

import java.util.List;

public class BKMInstallment {

    private Long bankId;
    private List<BKMInstallmentPrice> installmentPrices;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public List<BKMInstallmentPrice> getInstallmentPrices() {
        return installmentPrices;
    }

    public void setInstallmentPrices(List<BKMInstallmentPrice> installmentPrices) {
        this.installmentPrices = installmentPrices;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("bankId", bankId)
                .append("installmentPrices", installmentPrices)
                .toString();
    }
}
