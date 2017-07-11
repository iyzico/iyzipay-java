package com.iyzipay.functional.builder.request;

import com.iyzipay.request.RetrieveBinNumberRequest;

public final class RetrieveBinNumberRequestBuilder extends BaseRequestBuilder {

    private String binNumber;

    private RetrieveBinNumberRequestBuilder() {
    }

    public static RetrieveBinNumberRequestBuilder create() {
        return new RetrieveBinNumberRequestBuilder();
    }

    public RetrieveBinNumberRequestBuilder binNumber(String binNumber) {
        this.binNumber = binNumber;
        return this;
    }

    public RetrieveBinNumberRequest build() {
        RetrieveBinNumberRequest retrieveBinNumberRequest = new RetrieveBinNumberRequest();
        retrieveBinNumberRequest.setLocale(locale);
        retrieveBinNumberRequest.setConversationId(conversationId);
        retrieveBinNumberRequest.setBinNumber(binNumber);
        return retrieveBinNumberRequest;
    }
}
