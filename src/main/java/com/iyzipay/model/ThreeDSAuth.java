package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSAuthRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class ThreeDSAuth extends Payment {

    public static ThreeDSAuth create(CreateThreeDSAuthRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/iyzipos/auth3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDSAuth.class);
    }

    public static ThreeDSAuth retrieve(RetrievePaymentRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/detail",
                getHttpHeaders(request, options),
                request,
                ThreeDSAuth.class);
    }
}
