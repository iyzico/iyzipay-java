package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateRefundRequest;

import java.math.BigDecimal;

public class ConnectRefund extends IyzipayResource {

    private String paymentId;
    private String paymentTransactionId;
    private BigDecimal price;
    private String connectorName;

    public static ConnectRefund create(CreateRefundRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/iyziconnect/refund",
                getHttpHeaders(request, options),
                request,
                ConnectRefund.class);
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

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
}
