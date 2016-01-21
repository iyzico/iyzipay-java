package com.iyzipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankTransfer {

    private String subMerchantKey;
    private String iban;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    @JsonProperty("marketplaceSubmerchantType")
    private String marketplaceSubMerchantType;

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getLegalCompanyTitle() {
        return legalCompanyTitle;
    }

    public void setLegalCompanyTitle(String legalCompanyTitle) {
        this.legalCompanyTitle = legalCompanyTitle;
    }

    public String getMarketplaceSubMerchantType() {
        return marketplaceSubMerchantType;
    }

    public void setMarketplaceSubMerchantType(String marketplaceSubMerchantType) {
        this.marketplaceSubMerchantType = marketplaceSubMerchantType;
    }
}
