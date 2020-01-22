package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.subscription.SubscriptionOrderOperationRequest;

public class SubscriptionPayment extends IyzipayResource {

    public static SubscriptionPayment retry(SubscriptionOrderOperationRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/operation/retry";
        return HttpClient.create().post(uri,
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionPayment.class);
    }
}
