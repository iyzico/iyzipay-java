package com.iyzipay.functional.builder.request;

import com.iyzipay.request.CreateApprovalRequest;

public final class CreateApprovalRequestBuilder extends BaseRequestBuilder {

    private String paymentTransactionId;

    private CreateApprovalRequestBuilder() {
    }

    public static CreateApprovalRequestBuilder create() {
        return new CreateApprovalRequestBuilder();
    }


    public CreateApprovalRequestBuilder paymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
        return this;
    }

    public CreateApprovalRequest build() {
        CreateApprovalRequest createApprovalRequest = new CreateApprovalRequest();
        createApprovalRequest.setLocale(locale);
        createApprovalRequest.setConversationId(conversationId);
        createApprovalRequest.setPaymentTransactionId(paymentTransactionId);
        return createApprovalRequest;
    }
}
