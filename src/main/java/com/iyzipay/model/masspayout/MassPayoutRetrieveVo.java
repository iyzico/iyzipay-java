package com.iyzipay.model.masspayout;

import com.iyzipay.model.masspayout.enumtype.MassPayoutStatus;
import java.math.BigDecimal;

public class MassPayoutRetrieveVo {
    private String externalId;
    private Long merchantId;
    private BigDecimal totalAmount;
    private BigDecimal totalSuccessfulAmount;
    private MassPayoutStatus massPayoutStatus;
    private String receivedDate;
    private String completedDate;
    private String canceledDate;
    private BigDecimal totalCommissionAmount;
    private String currency;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalSuccessfulAmount() {
        return totalSuccessfulAmount;
    }

    public void setTotalSuccessfulAmount(BigDecimal totalSuccessfulAmount) {
        this.totalSuccessfulAmount = totalSuccessfulAmount;
    }

    public MassPayoutStatus getMassPayoutStatus() {
        return massPayoutStatus;
    }

    public void setMassPayoutStatus(MassPayoutStatus massPayoutStatus) {
        this.massPayoutStatus = massPayoutStatus;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(String canceledDate) {
        this.canceledDate = canceledDate;
    }

    public BigDecimal getTotalCommissionAmount() {
        return totalCommissionAmount;
    }

    public void setTotalCommissionAmount(BigDecimal totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
