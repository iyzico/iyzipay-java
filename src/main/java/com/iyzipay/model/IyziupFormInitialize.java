package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;

public class IyziupFormInitialize extends IyziupFormInitializeResource {

    public static IyziupFormInitialize create(CreateIyziupFormInitializeRequest request, Options options) {
        String path = "/v1/iyziup/form/initialize";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                IyziupFormInitialize.class);
    }
}
