package com.iyzipay.functional.builder.request;

import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.Currency;
import com.iyzipay.model.SubMerchantType;
import com.iyzipay.request.CreateSubMerchantRequest;

public final class CreateSubMerchantRequestBuilder extends BaseRequestBuilder {

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
    private String subMerchantExternalId;
    private String identityNumber;
    private String taxNumber;
    private String subMerchantType;
    private String swiftCode;
    private String blockageAmount;
    private CreateSubMerchantRequestBuilder() {
    }

    public static CreateSubMerchantRequestBuilder create() {
        return new CreateSubMerchantRequestBuilder();
    }

    public CreateSubMerchantRequestBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CreateSubMerchantRequestBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CreateSubMerchantRequestBuilder gsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public CreateSubMerchantRequestBuilder address(String address) {
        this.address = address;
        return this;
    }

    public CreateSubMerchantRequestBuilder iban(String iban) {
        this.iban = iban;
        return this;
    }

    public CreateSubMerchantRequestBuilder taxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
        return this;
    }

    public CreateSubMerchantRequestBuilder contactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public CreateSubMerchantRequestBuilder contactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
        return this;
    }

    public CreateSubMerchantRequestBuilder legalCompanyTitle(String legalCompanyTitle) {
        this.legalCompanyTitle = legalCompanyTitle;
        return this;
    }

    public CreateSubMerchantRequestBuilder subMerchantExternalId(String subMerchantExternalId) {
        this.subMerchantExternalId = subMerchantExternalId;
        return this;
    }

    public CreateSubMerchantRequestBuilder identityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public CreateSubMerchantRequestBuilder taxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public CreateSubMerchantRequestBuilder subMerchantType(String subMerchantType) {
        this.subMerchantType = subMerchantType;
        return this;
    }

    public CreateSubMerchantRequestBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreateSubMerchantRequestBuilder swiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
        return this;
    }

    public CreateSubMerchantRequestBuilder blockageAmount(String blockageAmount) {
        this.blockageAmount = blockageAmount;
        return this;
    }


    public CreateSubMerchantRequest build() {
        CreateSubMerchantRequest createSubMerchantRequest = new CreateSubMerchantRequest();
        createSubMerchantRequest.setLocale(locale);
        createSubMerchantRequest.setConversationId(conversationId);
        createSubMerchantRequest.setName(name);
        createSubMerchantRequest.setEmail(email);
        createSubMerchantRequest.setGsmNumber(gsmNumber);
        createSubMerchantRequest.setAddress(address);
        createSubMerchantRequest.setIban(iban);
        createSubMerchantRequest.setTaxOffice(taxOffice);
        createSubMerchantRequest.setContactName(contactName);
        createSubMerchantRequest.setContactSurname(contactSurname);
        createSubMerchantRequest.setLegalCompanyTitle(legalCompanyTitle);
        createSubMerchantRequest.setSubMerchantExternalId(subMerchantExternalId);
        createSubMerchantRequest.setIdentityNumber(identityNumber);
        createSubMerchantRequest.setTaxNumber(taxNumber);
        createSubMerchantRequest.setSubMerchantType(subMerchantType);
        createSubMerchantRequest.setCurrency(currency);
        createSubMerchantRequest.setSwiftCode(swiftCode);
        createSubMerchantRequest.setBlockageAmount(blockageAmount);
        return createSubMerchantRequest;
    }

    public CreateSubMerchantRequestBuilder personalSubMerchantRequest() {
        this.subMerchantExternalId = RandomGenerator.randomId();
        this.subMerchantType = SubMerchantType.PERSONAL.name();
        this.contactName = "John";
        this.contactSurname = "Doe";
        this.identityNumber = "123456789";
        return this;
    }

    public CreateSubMerchantRequestBuilder privateSubMerchantRequest() {
        this.subMerchantExternalId = RandomGenerator.randomId();
        this.subMerchantType = SubMerchantType.PRIVATE_COMPANY.name();
        this.taxOffice = "Tax office";
        this.legalCompanyTitle = "John Doe inc";
        this.identityNumber = "31300864726";
        return this;
    }

    public CreateSubMerchantRequestBuilder limitedCompanySubMerchantRequest() {
        this.subMerchantExternalId = RandomGenerator.randomId();
        this.subMerchantType = SubMerchantType.LIMITED_OR_JOINT_STOCK_COMPANY.name();
        this.taxOffice = "Tax office";
        this.taxNumber = "9261877";
        this.legalCompanyTitle = "XYZ inc";
        return this;
    }
}
