package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

public class SubscriptionProductOperation extends IyzipayResource {

    public static SubscriptionProductOperation delete(String subscriptionProductReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().delete(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionProductOperation.class);
    }
}
