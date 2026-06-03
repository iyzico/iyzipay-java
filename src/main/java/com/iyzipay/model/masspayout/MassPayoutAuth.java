package com.iyzipay.model.masspayout;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.masspayout.MassPayoutAuthRequest;

public class MassPayoutAuth extends IyzipayResource {

    public static MassPayoutAuth auth(MassPayoutAuthRequest request, Options options) {
        String path = "/v1/mass/payout/auth";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/auth", request, options),
                request,
                MassPayoutAuth.class);
    }
}