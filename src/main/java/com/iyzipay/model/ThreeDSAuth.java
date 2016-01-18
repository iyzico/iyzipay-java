package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSAuthRequest;

public class ThreeDSAuth extends Payment {

    public static ThreeDSAuth create(CreateThreeDSAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/auth3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDSAuth.class)
                .getBody();
    }
}
