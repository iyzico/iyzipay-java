package com.iyzipay.functional.builder.request;

import com.iyzipay.request.RetrieveIyziupFormRequest;

public final class RetrieveIyziupFormRequestBuilder extends BaseRequestBuilder {

    private String token;

    private RetrieveIyziupFormRequestBuilder() {
    }

    public static RetrieveIyziupFormRequestBuilder create() {
        return new RetrieveIyziupFormRequestBuilder();
    }

    public RetrieveIyziupFormRequestBuilder token(String token) {
        this.token = token;
        return this;
    }

    public RetrieveIyziupFormRequest build() {
        RetrieveIyziupFormRequest retrieveIyziupFormRequest = new RetrieveIyziupFormRequest();
        retrieveIyziupFormRequest.setLocale(locale);
        retrieveIyziupFormRequest.setConversationId(conversationId);
        retrieveIyziupFormRequest.setToken(token);
        return retrieveIyziupFormRequest;
    }
}
