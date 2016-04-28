package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class ThreeDS extends PaymentResource {

    public static ThreeDS create(CreateThreeDSRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/auth3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDS.class);
    }

    public static ThreeDS retrieve(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/detail",
                getHttpHeaders(request, options),
                request,
                ThreeDS.class);
    }
}
