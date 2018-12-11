package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateSubMerchantRequest;
import com.iyzipay.request.RetrieveSubMerchantRequest;
import com.iyzipay.request.UpdateSubMerchantRequest;

public class SubMerchant extends IyzipayResource {

    private String name;
    private String email;
    private String gsmNumber;
    private String address;
    private String iban;
    private String swiftCode;
    private String currency;
    private String taxOffice;
    private String contactName;
    private String contactSurname;
    private String legalCompanyTitle;
    private String subMerchantExternalId;
    private String identityNumber;
    private String taxNumber;
    private String subMerchantType;
    private String subMerchantKey;

    public static SubMerchant create(CreateSubMerchantRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/onboarding/submerchant",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                SubMerchant.class);
    }

    public static SubMerchant update(UpdateSubMerchantRequest request, Options options) {
        return HttpClient.create().put(options.getBaseUrl() + "/onboarding/submerchant",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                SubMerchant.class);
    }

    public static SubMerchant retrieve(RetrieveSubMerchantRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/onboarding/submerchant/detail",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                SubMerchant.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
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

    public String getSubMerchantExternalId() {
        return subMerchantExternalId;
    }

    public void setSubMerchantExternalId(String subMerchantExternalId) {
        this.subMerchantExternalId = subMerchantExternalId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getSubMerchantType() {
        return subMerchantType;
    }

    public void setSubMerchantType(String subMerchantType) {
        this.subMerchantType = subMerchantType;
    }

    public String getSubMerchantKey() {
        return subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }
}
