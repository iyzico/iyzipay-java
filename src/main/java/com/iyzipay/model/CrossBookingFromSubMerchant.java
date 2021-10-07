package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCrossBookingRequest;

public class CrossBookingFromSubMerchant extends IyzipayResource {

    public static CrossBookingFromSubMerchant create(CreateCrossBookingRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/crossbooking/receive",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CrossBookingFromSubMerchant.class);
    }
}
