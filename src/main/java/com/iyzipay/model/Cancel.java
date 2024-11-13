package com.iyzipay.model;

import java.math.BigDecimal;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCancelRequest;

public class Cancel extends IyzipayResource {

    private String paymentId;
    private BigDecimal price;
    private String currency;
    private String connectorName;
    private String authCode;
    private String hostReference;
    private String cancelHostReference;

    public static Cancel create(CreateCancelRequest request, Options options) {
        String path = "/payment/cancel";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Cancel.class);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public String getCancelHostReference() {
        return cancelHostReference;
    }

    public void setCancelHostReference(String cancelHostReference) {
        this.cancelHostReference = cancelHostReference;
    }
}
