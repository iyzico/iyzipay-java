package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.RefundReason;

public class CreateCancelRequest extends Request {

    private String paymentId;
    private String ip;
    private RefundReason reason;
    private String description;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public RefundReason getReason() {
        return reason;
    }

    public void setReason(RefundReason reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("paymentId", paymentId)
                .append("ip", ip)
                .append("reason", reason)
                .append("description", description)
                .toString();
    }
}