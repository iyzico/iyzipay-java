package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectPaymentRequest;

public class ConnectPaymentAuth extends ConnectPayment {

    public static ConnectPaymentAuth create(CreateConnectPaymentRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/iyziconnect/auth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentAuth.class);
    }
}
