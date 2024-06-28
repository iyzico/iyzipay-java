package com.iyzipay.model.loyalty;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.model.LoyaltyResource;

public class LoyaltyInquire extends LoyaltyResource {

    public static LoyaltyInquire create(LoyaltyInquireRequest request, Options options) {
        String path = "/payment/loyalty/inquire";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                LoyaltyInquire.class);
    }

}

