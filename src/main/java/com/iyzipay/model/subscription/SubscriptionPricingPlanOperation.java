package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;

public class SubscriptionPricingPlanOperation extends IyzipayResource {

    public static SubscriptionPricingPlanOperation delete(String subscriptionPricingPlanReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/pricing-plans/" + subscriptionPricingPlanReferenceCode;
        return HttpClient.create().delete(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionPricingPlanOperation.class);
    }
}
