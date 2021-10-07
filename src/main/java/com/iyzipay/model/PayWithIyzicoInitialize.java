package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;

public class PayWithIyzicoInitialize extends PayWithIyzicoInitializeResource {
    public static PayWithIyzicoInitialize create(PayWithIyzicoInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/pay-with-iyzico/initialize",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                PayWithIyzicoInitialize.class);
    }
}
