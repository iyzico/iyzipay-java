package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

import java.math.BigDecimal;

public class PaymentPostAuth extends IyzipayResource {

    private String paymentId;
    private BigDecimal price;

    public static PaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/postauth",
                getHttpHeaders(request, options),
                request,
                PaymentPostAuth.class)
                .getBody();
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
}
