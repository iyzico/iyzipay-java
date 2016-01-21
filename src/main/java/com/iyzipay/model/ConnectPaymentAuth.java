package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectPaymentAuthRequest;

public class ConnectPaymentAuth extends ConnectPayment {

    public static ConnectPaymentAuth create(CreateConnectPaymentAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/auth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentAuth.class)
                .getBody();
    }
}
