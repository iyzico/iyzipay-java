package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class ConnectPaymentPostAuth extends ConnectPayment {

    public static ConnectPaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/postauth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentPostAuth.class);
    }
}
