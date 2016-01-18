package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;
import com.iyzipay.model.BKMInstallment;

import java.math.BigDecimal;
import java.util.List;

public class CreateConnectBKMInitializeRequest extends Request {

    private String connectorName;
    private BigDecimal price;
    private String callbackUrl;
    private String buyerEmail;
    private String buyerId;
    private String buyerIp;
    private List<BKMInstallment> installmentDetails;

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
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

    public List<BKMInstallment> getInstallmentDetails() {
        return installmentDetails;
    }

    public void setInstallmentDetails(List<BKMInstallment> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("connectorName", connectorName)
                .append("price", price)
                .append("callbackUrl", callbackUrl)
                .append("buyerEmail", buyerEmail)
                .append("buyerId", buyerId)
                .append("buyerIp", buyerIp)
                .append("installmentDetails", installmentDetails)
                .toString();
    }
}
