package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

public class SubscriptionCustomerOperation extends IyzipayResource {

    public static SubscriptionCustomerOperation delete(String subscriptionCustomerReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().delete(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCustomerOperation.class);
    }
}

