package com.iyzipay.request.requesttopay;

import com.iyzipay.Request;

import java.math.BigDecimal;

public class ReplyRequestToPayRequest extends Request {

    private BigDecimal amount;
    private String paymentDateTime;
    private String referenceNumber;
    private String description;

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPaymentDateTime() { return paymentDateTime; }
    public void setPaymentDateTime(String paymentDateTime) { this.paymentDateTime = paymentDateTime; }

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}