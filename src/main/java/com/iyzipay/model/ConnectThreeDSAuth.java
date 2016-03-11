package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectThreeDSAuthRequest;

public class ConnectThreeDSAuth extends ConnectPayment {

    public static ConnectThreeDSAuth create(CreateConnectThreeDSAuthRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/iyziconnect/auth3ds",
                getHttpHeaders(request, options),
                request,
                ConnectThreeDSAuth.class);
    }
}
