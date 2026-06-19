package com.iyzipay.request.requesttopay;

import com.iyzipay.Request;
import com.iyzipay.model.requesttopay.enumtype.PaymentPurpose;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateRequestToPayRequest extends Request {

    private BigDecimal amount;
    private String receiverName;
    private String receiverIban;
    private PaymentPurpose paymentPurpose;
    private Long kolasReferenceNumber;
    private String qrReferenceNumber;
    private String expirationDateTime;
    private String requestedPaymentDateTime;
    private String description;
    private Boolean partialPayment;
    private Boolean earlyPayment;
    private Boolean deferredPayment;
    private String channelType;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverIban() {
        return receiverIban;
    }

    public void setReceiverIban(String receiverIban) {
        this.receiverIban = receiverIban;
    }

    public PaymentPurpose getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(PaymentPurpose paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public Long getKolasReferenceNumber() {
        return kolasReferenceNumber;
    }

    public void setKolasReferenceNumber(Long kolasReferenceNumber) {
        this.kolasReferenceNumber = kolasReferenceNumber;
    }

    public String getQrReferenceNumber() {
        return qrReferenceNumber;
    }

    public void setQrReferenceNumber(String qrReferenceNumber) {
        this.qrReferenceNumber = qrReferenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPartialPayment() {
        return partialPayment;
    }

    public void setPartialPayment(Boolean partialPayment) {
        this.partialPayment = partialPayment;
    }

    public Boolean getEarlyPayment() {
        return earlyPayment;
    }

    public void setEarlyPayment(Boolean earlyPayment) {
        this.earlyPayment = earlyPayment;
    }

    public Boolean getDeferredPayment() {
        return deferredPayment;
    }

    public void setDeferredPayment(Boolean deferredPayment) {
        this.deferredPayment = deferredPayment;
    }

    public String getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(String expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public String getRequestedPaymentDateTime() {
        return requestedPaymentDateTime;
    }

    public void setRequestedPaymentDateTime(String requestedPaymentDateTime) {
        this.requestedPaymentDateTime = requestedPaymentDateTime;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}