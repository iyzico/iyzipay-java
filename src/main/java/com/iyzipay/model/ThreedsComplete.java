package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.ThreedsCompleteRequest;

public class ThreedsComplete extends PaymentResource {


    public static ThreedsComplete create(ThreedsCompleteRequest request, Options options) {
        String path = "/iyzipos/3dsecure/complete";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                ThreedsComplete.class);
    }
}
