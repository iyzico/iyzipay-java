package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

public class CheckoutFormInitializePreAuth extends CheckoutFormInitializeResource {

    public static CheckoutFormInitializePreAuth create(CreateCheckoutFormInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/checkoutform/initialize/preauth/ecom",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CheckoutFormInitializePreAuth.class);
    }
}
