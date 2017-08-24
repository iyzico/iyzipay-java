package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.InitializeCardManagementPageRequest;

public class CardManagementPageInitialize extends CardManagementPageResource {

    public static CardManagementPageInitialize create(InitializeCardManagementPageRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/api/v1/forms",
                getHttpHeaders(request, options),
                request,
                CardManagementPageInitialize.class);
    }

}
