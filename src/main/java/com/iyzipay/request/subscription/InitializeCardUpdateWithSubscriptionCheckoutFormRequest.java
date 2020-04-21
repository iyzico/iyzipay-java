package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class InitializeCardUpdateWithSubscriptionCheckoutFormRequest extends Request {

    private String subscriptionReferenceCode;
    private String callbackUrl;

    public String getSubscriptionReferenceCode() {
        return subscriptionReferenceCode;
    }

    public void setSubscriptionReferenceCode(String subscriptionReferenceCode) {
        this.subscriptionReferenceCode = subscriptionReferenceCode;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
