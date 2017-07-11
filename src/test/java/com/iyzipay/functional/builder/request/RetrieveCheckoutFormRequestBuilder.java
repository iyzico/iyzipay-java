package com.iyzipay.functional.builder.request;

import com.iyzipay.request.RetrieveCheckoutFormRequest;

public final class RetrieveCheckoutFormRequestBuilder extends BaseRequestBuilder {

    private String token;

    private RetrieveCheckoutFormRequestBuilder() {
    }

    public static RetrieveCheckoutFormRequestBuilder create() {
        return new RetrieveCheckoutFormRequestBuilder();
    }

    public RetrieveCheckoutFormRequestBuilder token(String token) {
        this.token = token;
        return this;
    }

    public RetrieveCheckoutFormRequest build() {
        RetrieveCheckoutFormRequest retrieveCheckoutFormRequest = new RetrieveCheckoutFormRequest();
        retrieveCheckoutFormRequest.setLocale(locale);
        retrieveCheckoutFormRequest.setConversationId(conversationId);
        retrieveCheckoutFormRequest.setToken(token);
        return retrieveCheckoutFormRequest;
    }
}
