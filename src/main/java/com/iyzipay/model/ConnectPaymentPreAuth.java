package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectPaymentAuthRequest;
import com.iyzipay.request.CreateConnectPaymentPreAuthRequest;

public class ConnectPaymentPreAuth extends ConnectPayment {

    public static ConnectPaymentPreAuth create(CreateConnectPaymentPreAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/preauth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentPreAuth.class)
                .getBody();
    }
}
