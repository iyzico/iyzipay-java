package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCrossBookingRequest;

public class CrossBookingFromSubMerchant extends IyzipayResource {

    public static CrossBookingFromSubMerchant create(CreateCrossBookingRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/crossbooking/receive",
                getHttpHeaders(request, options),
                request,
                CrossBookingFromSubMerchant.class);
    }
}
