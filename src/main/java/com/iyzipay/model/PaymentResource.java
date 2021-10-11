package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class PaymentResource extends IyzipayResource {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private String currency;
    private Integer installment;
    private String paymentId;
    private String paymentStatus;
    private Integer fraudStatus;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private String cardToken;
    private String cardUserKey;
    private String binNumber;
    private String basketId;
    @SerializedName("itemTransactions")
    private List<PaymentItem> paymentItems;
    private String connectorName;
    private String authCode;
    private String phase;
    private String lastFourDigits;
    private String posOrderId;
    private String hostReference;
    private String iban;
    private String legalCompanyTitle;
    private String bankName;
    private String referenceCode;
    private Integer mdStatus;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getFraudStatus() {
        return fraudStatus;
    }

    public void setFraudStatus(Integer fraudStatus) {
        this.fraudStatus = fraudStatus;
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

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public List<PaymentItem> getPaymentItems() {
        return paymentItems;
    }

    public void setPaymentItems(List<PaymentItem> paymentItems) {
        this.paymentItems = paymentItems;
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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getPosOrderId() {
        return posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLegalCompanyTitle() {
        return legalCompanyTitle;
    }

    public void setLegalCompanyTitle(String legalCompanyTitle) {
        this.legalCompanyTitle = legalCompanyTitle;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Integer getMdStatus() {
        return mdStatus;
    }

    public void setMdStatus(Integer mdStatus) {
        this.mdStatus = mdStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
