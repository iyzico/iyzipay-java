package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveCheckoutFormRequest;

public class CheckoutForm extends PaymentResource {

    private String token;
    private String callbackUrl;

    public static CheckoutForm retrieve(RetrieveCheckoutFormRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/checkoutform/auth/ecom/detail",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CheckoutForm.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
