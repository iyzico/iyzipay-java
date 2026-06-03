package com.iyzipay.model.masspayout;

import com.iyzipay.model.masspayout.enumtype.OrderStatus;
import java.math.BigDecimal;

public class MassPayoutOrderRetrieveVo {
    private String itemExternalId;
    private String referenceCode;
    private String recipientType;
    private String recipientName;
    private String recipientInfo;
    private String description;
    private OrderStatus itemStatus;
    private String errorMessage;
    private BigDecimal totalAmount;
    private BigDecimal commissionAmount;
    private String currencyCode;
    private String massPayoutRequestId;

    public String getItemExternalId() {
        return itemExternalId;
    }

    public void setItemExternalId(String itemExternalId) {
        this.itemExternalId = itemExternalId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientInfo() {
        return recipientInfo;
    }

    public void setRecipientInfo(String recipientInfo) {
        this.recipientInfo = recipientInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(OrderStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMassPayoutRequestId() {
        return massPayoutRequestId;
    }

    public void setMassPayoutRequestId(String massPayoutRequestId) {
        this.massPayoutRequestId = massPayoutRequestId;
    }
}
