package com.iyzipay.functional.builder.request;

import com.iyzipay.request.CreateCancelRequest;

public class CreateCancelRequestBuilder extends BaseRequestBuilder {

    private String paymentId;
    private String ip = "85.34.78.112";

    private CreateCancelRequestBuilder() {
    }

    public static CreateCancelRequestBuilder create() {
        return new CreateCancelRequestBuilder();
    }

    public CreateCancelRequestBuilder paymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public CreateCancelRequestBuilder ip(String ip) {
        this.ip = ip;
        return this;
    }

    public CreateCancelRequest build() {
        CreateCancelRequest cancelRequest = new CreateCancelRequest();
        cancelRequest.setPaymentId(paymentId);
        cancelRequest.setIp(ip);
        return cancelRequest;
    }
}
