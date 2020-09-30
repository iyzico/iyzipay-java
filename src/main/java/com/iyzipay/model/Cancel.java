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

    public static Cancel create(CreateCancelRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/cancel",
                getHttpProxy(options),
                getHttpHeaders(request, options),
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
}
