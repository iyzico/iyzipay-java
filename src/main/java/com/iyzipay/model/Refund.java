package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateRefundRequest;

import java.math.BigDecimal;

public class Refund extends IyzipayResource {

    private String paymentId;
    private String paymentTransactionId;
    private BigDecimal price;

    public static Refund create(CreateRefundRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/iyzipos/refund",
                getHttpHeaders(request, options),
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
}
