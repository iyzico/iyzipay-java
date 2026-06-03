package com.iyzipay.model.masspayout;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

public class MassPayoutCancel extends IyzipayResource {

    public static MassPayoutCancel cancel(String requestId, Options options) {
        String path = "/v1/mass/payout/cancel/" + requestId;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2("/v1/mass/payout/cancel/" + requestId, null, options),
                null,
                MassPayoutCancel.class);
    }
}