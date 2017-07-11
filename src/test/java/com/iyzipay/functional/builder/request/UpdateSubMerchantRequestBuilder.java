package com.iyzipay.functional.builder.request;

import com.iyzipay.model.Currency;
import com.iyzipay.request.UpdateSubMerchantRequest;

public final class UpdateSubMerchantRequestBuilder extends BaseRequestBuilder {

    private String name = "John's market";
    private String email = "email@submerchantemail.com";
    private String gsmNumber = "+905350000000";
    private String address = "Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1";
    private String iban = "TR180006200119000006672315";
    private String currency = Currency.TRY.name();
    private String taxOffice;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    private String subMerchantKey;
    private String identityNumber;
    private String taxNumber;
    private String swiftCode;

    private UpdateSubMerchantRequestBuilder() {
    }

    public static UpdateSubMerchantRequestBuilder create() {
        return new UpdateSubMerchantRequestBuilder();
    }

    public UpdateSubMerchantRequestBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UpdateSubMerchantRequestBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UpdateSubMerchantRequestBuilder gsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public UpdateSubMerchantRequestBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UpdateSubMerchantRequestBuilder iban(String iban) {
        this.iban = iban;
        return this;
    }

    public UpdateSubMerchantRequestBuilder taxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
        return this;
    }

    public UpdateSubMerchantRequestBuilder contactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public UpdateSubMerchantRequestBuilder contactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
        return this;
    }

    public UpdateSubMerchantRequestBuilder legalCompanyTitle(String legalCompanyTitle) {
        this.legalCompanyTitle = legalCompanyTitle;
        return this;
    }

    public UpdateSubMerchantRequestBuilder subMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
        return this;
    }

    public UpdateSubMerchantRequestBuilder identityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public UpdateSubMerchantRequestBuilder taxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public UpdateSubMerchantRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public UpdateSubMerchantRequestBuilder swiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
        return this;
    }

    public UpdateSubMerchantRequest build() {
        UpdateSubMerchantRequest updateSubMerchantRequest = new UpdateSubMerchantRequest();
        updateSubMerchantRequest.setLocale(locale);
        updateSubMerchantRequest.setConversationId(conversationId);
        updateSubMerchantRequest.setName(name);
        updateSubMerchantRequest.setEmail(email);
        updateSubMerchantRequest.setGsmNumber(gsmNumber);
        updateSubMerchantRequest.setAddress(address);
        updateSubMerchantRequest.setIban(iban);
        updateSubMerchantRequest.setTaxOffice(taxOffice);
        updateSubMerchantRequest.setContactName(contactName);
        updateSubMerchantRequest.setContactSurname(contactSurname);
        updateSubMerchantRequest.setLegalCompanyTitle(legalCompanyTitle);
        updateSubMerchantRequest.setSubMerchantKey(subMerchantKey);
        updateSubMerchantRequest.setIdentityNumber(identityNumber);
        updateSubMerchantRequest.setTaxNumber(taxNumber);
        updateSubMerchantRequest.setCurrency(currency);
        updateSubMerchantRequest.setSwiftCode(swiftCode);
        return updateSubMerchantRequest;
    }
}
