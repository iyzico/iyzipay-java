package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectPaymentRequest;

public class ConnectPaymentPreAuth extends ConnectPayment {

    public static ConnectPaymentPreAuth create(CreateConnectPaymentRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/iyziconnect/preauth",
                getHttpHeaders(request, options),
                request,
                ConnectPaymentPreAuth.class);
    }
}
