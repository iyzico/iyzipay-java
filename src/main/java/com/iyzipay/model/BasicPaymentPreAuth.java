package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicPaymentPreAuth extends BasicPaymentResource {

    public static BasicPaymentPreAuth create(CreateBasicPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/preauth/basic",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BasicPaymentPreAuth.class);
    }
}
