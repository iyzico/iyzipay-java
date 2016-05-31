package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCancelRequest;

import java.math.BigDecimal;

public class Cancel extends IyzipayResource {

    private String paymentId;
    private BigDecimal price;
    private String connectorName;

    public static Cancel create(CreateCancelRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/cancel",
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

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
}
