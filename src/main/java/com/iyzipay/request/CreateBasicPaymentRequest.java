package com.iyzipay.request;

import com.iyzipay.Constants;
import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.PaymentCard;

import java.math.BigDecimal;

public class CreateBasicPaymentRequest extends Request {

    private BigDecimal price;
    private BigDecimal paidPrice;
    private Integer installment;
    private String buyerEmail;
    private String buyerId;
    private String buyerIp;
    private String posOrderId;
    private PaymentCard paymentCard;
    private String currency;
    private String connectorName;
    private String callbackUrl;

    public CreateBasicPaymentRequest() {
        setInstallment(Constants.SINGLE_INSTALLMENT);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerIp() {
        return buyerIp;
    }

    public void setBuyerIp(String buyerIp) {
        this.buyerIp = buyerIp;
    }

    public String getPosOrderId() {
        return posOrderId;
    }

    public void setPosOrderId(String posOrderId) {
        this.posOrderId = posOrderId;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("price", price)
                .append("paidPrice", paidPrice)
                .append("installment", installment)
                .append("buyerEmail", buyerEmail)
                .append("buyerId", buyerId)
                .append("buyerIp", buyerIp)
                .append("posOrderId", posOrderId)
                .append("paymentCard", paymentCard)
                .append("currency", currency)
                .append("connectorName", connectorName)
                .append("callbackUrl", callbackUrl)
                .toString();
    }
}
