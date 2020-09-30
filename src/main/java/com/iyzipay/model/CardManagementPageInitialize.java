package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCardManagementPageInitializeRequest;

public class CardManagementPageInitialize extends IyzipayResource {

    private String externalId;
    private String token;
    private String cardPageUrl;

    public static CardManagementPageInitialize create(CreateCardManagementPageInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/v1/card-management/pages",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CardManagementPageInitialize.class);
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCardPageUrl() {
        return cardPageUrl;
    }

    public void setCardPageUrl(String cardPageUrl) {
        this.cardPageUrl = cardPageUrl;
    }

}
