package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;

public class PaymentAuth extends Payment {

    // It's not convenient to have to pass the options every time I make a
    // request, I would prefer to have a factory with interface, initialized
    // with options. Then I would just give the reqest and call, similar to the
    // current Iyzipay client I'm using. That makes it easier to use for DI.
    public static PaymentAuth create(CreatePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/auth/ecom",
                getHttpHeaders(request, options),
                request,
                PaymentAuth.class);
    }
}
