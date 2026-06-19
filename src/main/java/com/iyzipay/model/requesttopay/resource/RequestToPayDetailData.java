package com.iyzipay.model.requesttopay.resource;

import com.iyzipay.model.requesttopay.enumtype.PaymentPurpose;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayRole;
import com.iyzipay.model.requesttopay.enumtype.RequestToPayStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RequestToPayDetailData {

    private String referenceNumber;
    private BigDecimal amount;
    private String receiverName;
    private String receiverIban;
    private String senderName;
    private String senderIban;
    private PaymentPurpose paymentPurpose;
    private Long kolasReferenceNumber;
    private String qrReferenceNumber;
    private LocalDateTime expirationDateTime;
    private LocalDateTime requestedPaymentDateTime;
    private String description;
    private Boolean partialPayment;
    private Boolean earlyPayment;
    private Boolean deferredPayment;
    private RequestToPayStatus status;
    private RequestToPayRole requestToPayRole;
    private LocalDateTime createdDate;

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public String getReceiverIban() { return receiverIban; }
    public void setReceiverIban(String receiverIban) { this.receiverIban = receiverIban; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public String getSenderIban() { return senderIban; }
    public void setSenderIban(String senderIban) { this.senderIban = senderIban; }
    public PaymentPurpose getPaymentPurpose() { return paymentPurpose; }
    public void setPaymentPurpose(PaymentPurpose paymentPurpose) { this.paymentPurpose = paymentPurpose; }
    public Long getKolasReferenceNumber() { return kolasReferenceNumber; }
    public void setKolasReferenceNumber(Long kolasReferenceNumber) { this.kolasReferenceNumber = kolasReferenceNumber; }
    public String getQrReferenceNumber() { return qrReferenceNumber; }
    public void setQrReferenceNumber(String qrReferenceNumber) { this.qrReferenceNumber = qrReferenceNumber; }
    public LocalDateTime getExpirationDateTime() { return expirationDateTime; }
    public void setExpirationDateTime(LocalDateTime expirationDateTime) { this.expirationDateTime = expirationDateTime; }
    public LocalDateTime getRequestedPaymentDateTime() { return requestedPaymentDateTime; }
    public void setRequestedPaymentDateTime(LocalDateTime requestedPaymentDateTime) { this.requestedPaymentDateTime = requestedPaymentDateTime; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getPartialPayment() { return partialPayment; }
    public void setPartialPayment(Boolean partialPayment) { this.partialPayment = partialPayment; }
    public Boolean getEarlyPayment() { return earlyPayment; }
    public void setEarlyPayment(Boolean earlyPayment) { this.earlyPayment = earlyPayment; }
    public Boolean getDeferredPayment() { return deferredPayment; }
    public void setDeferredPayment(Boolean deferredPayment) { this.deferredPayment = deferredPayment; }
    public RequestToPayStatus getStatus() { return status; }
    public void setStatus(RequestToPayStatus status) { this.status = status; }
    public RequestToPayRole getRequestToPayRole() { return requestToPayRole; }
    public void setRequestToPayRole(RequestToPayRole requestToPayRole) { this.requestToPayRole = requestToPayRole; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}