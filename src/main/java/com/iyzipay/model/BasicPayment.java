package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicPayment extends BasicPaymentResource {

    public static BasicPayment create(CreateBasicPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/auth/basic",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BasicPayment.class);
    }
}
