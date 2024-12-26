package com.iyzipay.model;

import java.math.BigDecimal;
import java.util.Arrays;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreateRefundRequest;
import com.iyzipay.request.CreateRefundV2Request;

public class Refund extends IyzipayResource implements ResponseSignatureGenerator {

    private String paymentId;
    private String paymentTransactionId;
    private BigDecimal price;
    private String currency;
    private String connectorName;
    private String authCode;
    private String hostReference;
    private String refundHostReference;
    private String signature;

    public static Refund create(CreateRefundRequest request, Options options) {
        String path = "/payment/refund";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Refund.class);
    }

    public static Refund createV2(CreateRefundV2Request request, Options options) {
        String path = "/v2/payment/refund";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Refund.class);
    }

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentId(), getPrice(), getCurrency(), getConversationId()));
        return HashValidator.hashValid(getSignature(), calculated);
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
