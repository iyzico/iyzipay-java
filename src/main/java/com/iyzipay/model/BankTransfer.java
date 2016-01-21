package com.iyzipay.model;

public class BankTransfer {

    private String subMerchantKey;
    private String iban;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    private String marketplaceSubmerchantType;

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

    public String getMarketplaceSubmerchantType() {
        return marketplaceSubmerchantType;
    }

    public void setMarketplaceSubmerchantType(String marketplaceSubmerchantType) {
        this.marketplaceSubmerchantType = marketplaceSubmerchantType;
    }
}
