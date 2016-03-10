package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCrossBookingRequest;

public class CrossBookingToSubMerchant extends IyzipayResource {

    public static CrossBookingToSubMerchant create(CreateCrossBookingRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/crossbooking/send",
                getHttpHeaders(request, options),
                request,
                CrossBookingToSubMerchant.class);
    }
}
