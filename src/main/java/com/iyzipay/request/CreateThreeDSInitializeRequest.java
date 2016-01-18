package com.iyzipay.request;

import com.iyzipay.ToStringRequestBuilder;

public class CreateThreeDSInitializeRequest extends CreatePaymentRequest {

    private String callbackUrl;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("callbackUrl", callbackUrl)
                .toString();
    }
}
