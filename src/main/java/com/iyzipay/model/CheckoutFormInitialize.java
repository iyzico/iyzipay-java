package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

public class CheckoutFormInitialize extends CheckoutFormInitializeResource {

    public static CheckoutFormInitialize create(CreateCheckoutFormInitializeRequest request, Options options) {
        String path = "/payment/iyzipos/checkoutform/initialize/auth/ecom";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CheckoutFormInitialize.class);
    }
}
