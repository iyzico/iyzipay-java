package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSRequest;

public class BasicThreeDS extends BasicPaymentResource {

    public static BasicThreeDS create(CreateThreeDSRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/auth3ds",
                getHttpHeaders(request, options),
                request,
                BasicThreeDS.class);
    }
}
