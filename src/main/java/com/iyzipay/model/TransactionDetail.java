package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class TransactionDetail {

    private String transactionType;
    private String transactionDate;
    private Long transactionId;
    private Integer transactionStatus;
    private Integer afterSettlement;
    private Long paymentTxId;
    private Long paymentId;
    private String conversationId;
    private String paymentPhase;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private String transactionCurrency;
    private Integer installment;
    private Integer threeDS;
    private BigDecimal iyzicoCommission;
    private BigDecimal iyzicoFee;
    private BigDecimal parity;
    private BigDecimal iyzicoConversionAmount;
    private String settlementCurrency;
    private BigDecimal merchantPayoutAmount;
    private String connectorType;
    private String posOrderId;
    private String posName;
    private String subMerchantKey;
    private BigDecimal subMerchantPayoutAmount;
    private String authCode;
    private String hostReference;
    private String basketId;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Integer getAfterSettlement() {
        return afterSettlement;
    }

    public void setAfterSettlement(Integer afterSettlement) {
        this.afterSettlement = afterSettlement;
    }

    public Long getPaymentTxId() {
        return paymentTxId;
    }

    public void setPaymentTxId(Long paymentTxId) {
        this.paymentTxId = paymentTxId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getPaymentPhase() {
        return paymentPhase;
    }

    public void setPaymentPhase(String paymentPhase) {
        this.paymentPhase = paymentPhase;
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

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Integer getThreeDS() {
        return threeDS;
    }

    public void setThreeDS(Integer threeDS) {
        this.threeDS = threeDS;
    }

    public BigDecimal getIyzicoCommission() {
        return iyzicoCommission;
    }

    public void setIyzicoCommission(BigDecimal iyzicoCommission) {
        this.iyzicoCommission = iyzicoCommission;
    }

    public BigDecimal getIyzicoFee() {
        return iyzicoFee;
    }

    public void setIyzicoFee(BigDecimal iyzicoFee) {
        this.iyzicoFee = iyzicoFee;
    }

    public BigDecimal getParity() {
        return parity;
    }

    public void setParity(BigDecimal parity) {
        this.parity = parity;
    }

    public BigDecimal getIyzicoConversionAmount() {
        return iyzicoConversionAmount;
    }

    public void setIyzicoConversionAmount(BigDecimal iyzicoConversionAmount) {
        this.iyzicoConversionAmount = iyzicoConversionAmount;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public BigDecimal getMerchantPayoutAmount() {
        return merchantPayoutAmount;
    }

    public void setMerchantPayoutAmount(BigDecimal merchantPayoutAmount) {
        this.merchantPayoutAmount = merchantPayoutAmount;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public String getPosOrderId() {
        return posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getSubMerchantPayoutAmount() {
        return subMerchantPayoutAmount;
    }

    public void setSubMerchantPayoutAmount(BigDecimal subMerchantPayoutAmount) {
        this.subMerchantPayoutAmount = subMerchantPayoutAmount;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
