package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentTxDetail {

    private String itemId;
    private Long paymentTransactionId;
    private Integer transactionStatus;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private BigDecimal blockageRate;
    private BigDecimal blockageRateAmountMerchant;
    private BigDecimal blockageRateAmountSubMerchant;
    private Date blockageResolvedDate;
    private String subMerchantKey;
    private BigDecimal subMerchantPrice;
    private BigDecimal subMerchantPayoutRate;
    private BigDecimal subMerchantPayoutAmount;
    private BigDecimal merchantPayoutAmount;
    private PaymentTxPayoutDetail convertedPayout;
    private List<RefundTxDetail> refunds;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public BigDecimal getMerchantCommissionRate() {
        return merchantCommissionRate;
    }

    public void setMerchantCommissionRate(BigDecimal merchantCommissionRate) {
        this.merchantCommissionRate = merchantCommissionRate;
    }

    public BigDecimal getMerchantCommissionRateAmount() {
        return merchantCommissionRateAmount;
    }

    public void setMerchantCommissionRateAmount(BigDecimal merchantCommissionRateAmount) {
        this.merchantCommissionRateAmount = merchantCommissionRateAmount;
    }

    public BigDecimal getIyziCommissionRateAmount() {
        return iyziCommissionRateAmount;
    }

    public void setIyziCommissionRateAmount(BigDecimal iyziCommissionRateAmount) {
        this.iyziCommissionRateAmount = iyziCommissionRateAmount;
    }

    public BigDecimal getIyziCommissionFee() {
        return iyziCommissionFee;
    }

    public void setIyziCommissionFee(BigDecimal iyziCommissionFee) {
        this.iyziCommissionFee = iyziCommissionFee;
    }

    public BigDecimal getBlockageRate() {
        return blockageRate;
    }

    public void setBlockageRate(BigDecimal blockageRate) {
        this.blockageRate = blockageRate;
    }

    public BigDecimal getBlockageRateAmountMerchant() {
        return blockageRateAmountMerchant;
    }

    public void setBlockageRateAmountMerchant(BigDecimal blockageRateAmountMerchant) {
        this.blockageRateAmountMerchant = blockageRateAmountMerchant;
    }

    public BigDecimal getBlockageRateAmountSubMerchant() {
        return blockageRateAmountSubMerchant;
    }

    public void setBlockageRateAmountSubMerchant(BigDecimal blockageRateAmountSubMerchant) {
        this.blockageRateAmountSubMerchant = blockageRateAmountSubMerchant;
    }

    public Date getBlockageResolvedDate() {
        return blockageResolvedDate;
    }

    public void setBlockageResolvedDate(Date blockageResolvedDate) {
        this.blockageResolvedDate = blockageResolvedDate;
    }

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getSubMerchantPrice() {
        return subMerchantPrice;
    }

    public void setSubMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
    }

    public BigDecimal getSubMerchantPayoutRate() {
        return subMerchantPayoutRate;
    }

    public void setSubMerchantPayoutRate(BigDecimal subMerchantPayoutRate) {
        this.subMerchantPayoutRate = subMerchantPayoutRate;
    }

    public BigDecimal getSubMerchantPayoutAmount() {
        return subMerchantPayoutAmount;
    }

    public void setSubMerchantPayoutAmount(BigDecimal subMerchantPayoutAmount) {
        this.subMerchantPayoutAmount = subMerchantPayoutAmount;
    }

    public BigDecimal getMerchantPayoutAmount() {
        return merchantPayoutAmount;
    }

    public void setMerchantPayoutAmount(BigDecimal merchantPayoutAmount) {
        this.merchantPayoutAmount = merchantPayoutAmount;
    }

    public PaymentTxPayoutDetail getConvertedPayout() {
        return convertedPayout;
    }

    public void setConvertedPayout(PaymentTxPayoutDetail convertedPayout) {
        this.convertedPayout = convertedPayout;
    }

    public List<RefundTxDetail> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<RefundTxDetail> refunds) {
        this.refunds = refunds;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
