package com.iyzipay.functional.builder.request;

import com.iyzipay.request.RetrieveCardManagementPageCardRequest;

public class CardManagementRetrieveCardBuilder extends BaseRequestBuilder {

    private String pageToken;

    private CardManagementRetrieveCardBuilder() {
    }

    public static CardManagementRetrieveCardBuilder create() {
        return new CardManagementRetrieveCardBuilder();
    }

    public CardManagementRetrieveCardBuilder pageToken(String pageToken) {
        this.pageToken = pageToken;
        return this;
    }

    public RetrieveCardManagementPageCardRequest build() {
        RetrieveCardManagementPageCardRequest retrieveCardManagementPageCardRequest = new RetrieveCardManagementPageCardRequest();
        retrieveCardManagementPageCardRequest.setPageToken(this.pageToken);
        retrieveCardManagementPageCardRequest.setConversationId(this.conversationId);
        retrieveCardManagementPageCardRequest.setLocale(this.locale);

        return retrieveCardManagementPageCardRequest;
    }
}
