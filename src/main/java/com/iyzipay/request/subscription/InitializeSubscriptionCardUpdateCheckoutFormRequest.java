package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class InitializeSubscriptionCardUpdateCheckoutFormRequest extends Request {

    private String customerReferenceCode;
    private String callbackUrl;

    public String getCustomerReferenceCode() {
        return customerReferenceCode;
    }

    public void setCustomerReferenceCode(String customerReferenceCode) {
        this.customerReferenceCode = customerReferenceCode;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
