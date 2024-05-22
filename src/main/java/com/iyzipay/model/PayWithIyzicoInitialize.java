package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;


public class PayWithIyzicoInitialize extends PayWithIyzicoInitializeResource {
    public static PayWithIyzicoInitialize create(PayWithIyzicoInitializeRequest request, Options options) {
        String path = "/payment/pay-with-iyzico/initialize";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PayWithIyzicoInitialize.class);
    }
}
