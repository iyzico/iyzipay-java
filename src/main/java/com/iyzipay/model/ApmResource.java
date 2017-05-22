package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class ApmResource extends IyzipayResource {

    private String redirectUrl;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private String paymentId;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private String basketId;
    private String currency;
    @SerializedName("itemTransactions")
    private List<PaymentItem> paymentItems;
    private String phase;
    private String accountHolderName;
    private String accountNumber;
    private String bankName;
    private String bankCode;
    private String bic;
    private String paymentPurpose;
    private String iban;
    private String countryCode;
    private String apm;
    private String mobilePhone;
    private String paymentStatus;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public List<PaymentItem> getPaymentItems() {
        return paymentItems;
    }

    public void setPaymentItems(List<PaymentItem> paymentItems) {
        this.paymentItems = paymentItems;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
