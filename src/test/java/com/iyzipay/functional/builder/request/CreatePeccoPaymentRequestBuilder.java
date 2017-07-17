package com.iyzipay.functional.builder.request;

import com.iyzipay.request.CreatePeccoPaymentRequest;

public final class CreatePeccoPaymentRequestBuilder extends BaseRequestBuilder {

    private String token;

    private CreatePeccoPaymentRequestBuilder() {
    }

    public static CreatePeccoPaymentRequestBuilder create() {
        return new CreatePeccoPaymentRequestBuilder();
    }

    public CreatePeccoPaymentRequestBuilder token(String token) {
        this.token = token;
        return this;
    }

    public CreatePeccoPaymentRequest build() {
        CreatePeccoPaymentRequest createPeccoPaymentRequest = new CreatePeccoPaymentRequest();
        createPeccoPaymentRequest.setToken(token);
        return createPeccoPaymentRequest;
    }
}
