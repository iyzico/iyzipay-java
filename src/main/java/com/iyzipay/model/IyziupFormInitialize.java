package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;

public class IyziupFormInitialize extends IyziupFormInitializeResource {

    public static IyziupFormInitialize create(CreateIyziupFormInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/v1/iyziup/form/initialize",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                IyziupFormInitialize.class);
    }
}
