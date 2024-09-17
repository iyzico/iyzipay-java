package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicPaymentPreAuth extends BasicPaymentResource {

    public static BasicPaymentPreAuth create(CreateBasicPaymentRequest request, Options options) {
        String path = "/payment/preauth/basic";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicPaymentPreAuth.class);
    }
}
