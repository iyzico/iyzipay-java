package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCrossBookingRequest;

public class CrossBookingFromSubMerchant extends IyzipayResource {

    public static CrossBookingFromSubMerchant create(CreateCrossBookingRequest request, Options options) {
        String path = "/crossbooking/receive";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CrossBookingFromSubMerchant.class);
    }
}
