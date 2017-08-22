package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class CreateIyziupFormInitializeRequest extends Request {

    private String merchantOrderId;
    private String paymentGroup;
    private String paymentSource;
    private Integer forceThreeDS;
    private List<Integer> enabledInstallments;
    private String enabledCardFamily;
    private String currency;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private String callbackUrl;
    private String termsUrl;
    private String preSalesContractUrl;
    private List<OrderItem> orderItems;

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getPaymentGroup() {
        return paymentGroup;
    }

    public void setPaymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public Integer getForceThreeDS() {
        return forceThreeDS;
    }

    public void setForceThreeDS(Integer forceThreeDS) {
        this.forceThreeDS = forceThreeDS;
    }

    public List<Integer> getEnabledInstallments() {
        return enabledInstallments;
    }

    public void setEnabledInstallments(List<Integer> enabledInstallments) {
        this.enabledInstallments = enabledInstallments;
    }

    public String getEnabledCardFamily() {
        return enabledCardFamily;
    }

    public void setEnabledCardFamily(String enabledCardFamily) {
        this.enabledCardFamily = enabledCardFamily;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public String getPreSalesContractUrl() {
        return preSalesContractUrl;
    }

    public void setPreSalesContractUrl(String preSalesContractUrl) {
        this.preSalesContractUrl = preSalesContractUrl;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("merchantOrderId", merchantOrderId)
                .append("paymentGroup", paymentGroup)
                .append("paymentSource", paymentSource)
                .append("forceThreeDS", forceThreeDS)
                .append("enabledInstallments", enabledInstallments)
                .append("enabledCardFamily", enabledCardFamily)
                .append("currency", currency)
                .append("price", price)
                .append("paidPrice", paidPrice)
                .append("callbackUrl", callbackUrl)
                .append("termsUrl", termsUrl)
                .append("preSalesContractUrl", preSalesContractUrl)
                .append("orderItems", orderItems)
                .toString();
    }


}
