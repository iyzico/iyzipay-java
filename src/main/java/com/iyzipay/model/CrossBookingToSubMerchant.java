package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCrossBookingRequest;

public class CrossBookingToSubMerchant extends IyzipayResource {

    public static CrossBookingToSubMerchant create(CreateCrossBookingRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/crossbooking/send",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                CrossBookingToSubMerchant.class);
    }
}
