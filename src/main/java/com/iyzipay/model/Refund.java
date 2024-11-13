package com.iyzipay.model;

import java.math.BigDecimal;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateRefundRequest;

public class Refund extends IyzipayResource {

    private String paymentId;
    private String paymentTransactionId;
    private BigDecimal price;
    private String currency;
    private String connectorName;
    private String authCode;
    private String hostReference;
    private String refundHostReference;

    public static Refund create(CreateRefundRequest request, Options options) {
        String path = "/payment/refund";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Refund.class);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }
    public String getRefundHostReference() {
        return refundHostReference;
    }

    public void setRefundHostReference(String refundHostReference) {
        this.refundHostReference = refundHostReference;
    }
}
