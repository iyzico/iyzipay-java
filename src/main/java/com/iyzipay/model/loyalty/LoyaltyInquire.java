package com.iyzipay.model.loyalty;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.model.LoyaltyResource;

public class LoyaltyInquire extends LoyaltyResource {

    public static LoyaltyInquire create(LoyaltyInquireRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/loyalty/inquire",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                LoyaltyInquire.class);
    }

}

