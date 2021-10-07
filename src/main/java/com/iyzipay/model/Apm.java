package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateApmInitializeRequest;
import com.iyzipay.request.RetrieveApmRequest;

public class Apm extends ApmResource {

    public static Apm create(CreateApmInitializeRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/apm/initialize",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Apm.class);
    }

    public static Apm retrieve(RetrieveApmRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/apm/retrieve",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Apm.class);
    }
}
