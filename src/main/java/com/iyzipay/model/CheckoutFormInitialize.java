package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

public class CheckoutFormInitialize extends CheckoutFormInitializeResource {

    public static CheckoutFormInitialize create(CreateCheckoutFormInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/checkoutform/initialize/auth/ecom",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CheckoutFormInitialize.class);
    }
}
