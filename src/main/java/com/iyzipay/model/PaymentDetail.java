package com.iyzipay.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentDetail {

    private Long paymentId;
    private Integer paymentStatus;
    private String paymentRefundStatus;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private Integer installment;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private String paymentConversationId;
    private Integer fraudStatus;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private String cardToken;
    private String cardUserKey;
    private String binNumber;
    private String lastFourDigits;
    private String basketId;
    private String currency;
    private String connectorName;
    private String authCode;
    private boolean threeDS;
    private String phase;
    private String acquirerBankName;
    private Integer mdStatus;
    private String hostReference;
    private Date createdDate;
    private Date updatedDate;
    private String orderId;
    private List<RefundDetail> cancels;
    private List<PaymentTxDetail> itemTransactions;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentRefundStatus() {
        return paymentRefundStatus;
    }

    public void setPaymentRefundStatus(String paymentRefundStatus) {
        this.paymentRefundStatus = paymentRefundStatus;
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

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
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

    public String getPaymentConversationId() {
        return paymentConversationId;
    }

    public void setPaymentConversationId(String paymentConversationId) {
        this.paymentConversationId = paymentConversationId;
    }

    public Integer getFraudStatus() {
        return fraudStatus;
    }

    public void setFraudStatus(Integer fraudStatus) {
        this.fraudStatus = fraudStatus;
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

    public String getCardFamily() {
        return cardFamily;
    }

    public void setCardFamily(String cardFamily) {
        this.cardFamily = cardFamily;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public boolean isThreeDS() {
        return threeDS;
    }

    public void setThreeDS(boolean threeDS) {
        this.threeDS = threeDS;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getAcquirerBankName() {
        return acquirerBankName;
    }

    public void setAcquirerBankName(String acquirerBankName) {
        this.acquirerBankName = acquirerBankName;
    }

    public Integer getMdStatus() {
        return mdStatus;
    }

    public void setMdStatus(Integer mdStatus) {
        this.mdStatus = mdStatus;
    }

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<RefundDetail> getCancels() {
        return cancels;
    }

    public void setCancels(List<RefundDetail> cancels) {
        this.cancels = cancels;
    }

    public List<PaymentTxDetail> getItemTransactions() {
        return itemTransactions;
    }

    public void setItemTransactions(List<PaymentTxDetail> itemTransactions) {
        this.itemTransactions = itemTransactions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
