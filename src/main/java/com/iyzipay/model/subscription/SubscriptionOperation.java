package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionUpgradeData;
import com.iyzipay.request.subscription.SubscriptionOrderOperationRequest;
import com.iyzipay.request.subscription.UpgradeSubscriptionRequest;

public class SubscriptionOperation extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionUpgradeData subscriptionUpgradeData;

    public static SubscriptionOperation cancel(String subscriptionReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/cancel";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation activate(String subscriptionReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/activate";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation upgrade(String subscriptionReferenceCode, UpgradeSubscriptionRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/upgrade";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation retryPayment(SubscriptionOrderOperationRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/operation/retry";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionOperation.class);
    }
}
