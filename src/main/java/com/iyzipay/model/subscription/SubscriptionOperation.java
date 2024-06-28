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
        String path = "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/cancel";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation activate(String subscriptionReferenceCode, Options options) {
        String path = "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/activate";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation upgrade(String subscriptionReferenceCode, UpgradeSubscriptionRequest request, Options options) {
        String path = "/v2/subscription/subscriptions/" + subscriptionReferenceCode + "/upgrade";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubscriptionOperation.class);
    }

    public static SubscriptionOperation retryPayment(SubscriptionOrderOperationRequest request, Options options) {
        String path = "/v2/subscription/operation/retry";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubscriptionOperation.class);
    }

    public SubscriptionUpgradeData getSubscriptionUpgradeData() {
        return subscriptionUpgradeData;
    }

}
