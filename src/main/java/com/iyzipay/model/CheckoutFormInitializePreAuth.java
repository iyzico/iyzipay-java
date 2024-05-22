package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

public class CheckoutFormInitializePreAuth extends CheckoutFormInitializeResource {

    public static CheckoutFormInitializePreAuth create(CreateCheckoutFormInitializeRequest request, Options options) {
        String path = "/payment/iyzipos/checkoutform/initialize/preauth/ecom";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CheckoutFormInitializePreAuth.class);
    }
}
