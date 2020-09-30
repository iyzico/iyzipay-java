package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class BasicPaymentPostAuth extends BasicPaymentResource {

    public static BasicPaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/postauth/basic",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BasicPaymentPostAuth.class);
    }
}
