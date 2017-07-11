package com.iyzipay.functional.builder.request;

import com.iyzipay.request.RetrieveSubMerchantRequest;

public final class RetrieveSubMerchantRequestBuilder extends BaseRequestBuilder {

    private String subMerchantExternalId;

    private RetrieveSubMerchantRequestBuilder() {
    }

    public static RetrieveSubMerchantRequestBuilder create() {
        return new RetrieveSubMerchantRequestBuilder();
    }

    public RetrieveSubMerchantRequestBuilder subMerchantExternalId(String subMerchantExternalId) {
        this.subMerchantExternalId = subMerchantExternalId;
        return this;
    }

    public RetrieveSubMerchantRequest build() {
        RetrieveSubMerchantRequest retrieveSubMerchantRequest = new RetrieveSubMerchantRequest();
        retrieveSubMerchantRequest.setLocale(locale);
        retrieveSubMerchantRequest.setConversationId(conversationId);
        retrieveSubMerchantRequest.setSubMerchantExternalId(subMerchantExternalId);
        return retrieveSubMerchantRequest;
    }
}
