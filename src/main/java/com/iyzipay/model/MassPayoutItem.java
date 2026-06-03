package com.iyzipay.model;

import java.io.Serializable;

public class MassPayoutItem implements Serializable {
    private String itemExternalId;
    private String recipientType;
    private String recipientInfo;
    private Amount amount;
    private String description;
    private String recipientName;

    public String getItemExternalId() {
        return itemExternalId;
    }

    public void setItemExternalId(String itemExternalId) {
        this.itemExternalId = itemExternalId;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getRecipientInfo() {
        return recipientInfo;
    }

    public void setRecipientInfo(String recipientInfo) {
        this.recipientInfo = recipientInfo;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Override
    public String toString() {
        return "MassPayoutItem{" +
                "itemExternalId='" + itemExternalId + '\'' +
                ", recipientType='" + recipientType + '\'' +
                ", recipientInfo='" + recipientInfo + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", recipientName='" + recipientName + '\'' +
                '}';
    }
}
