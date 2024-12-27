package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class CreateRefundV2Request extends Request {

    private String paymentId;
    private BigDecimal price;
    private String ip;


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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("paymentId", paymentId)
                .append("price", price)
                .append("ip", ip)
                .toString();
    }
}