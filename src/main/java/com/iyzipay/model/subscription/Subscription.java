package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionData;

public class Subscription extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionData subscriptionData;

    public static Subscription retrieve(String subscriptionReferenceCode, Options options) {
        String path = "/v2/subscription/subscriptions/" + subscriptionReferenceCode;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                Subscription.class);
    }

    public SubscriptionData getSubscriptionData() {
        return subscriptionData;
    }

    public void setSubscriptionData(SubscriptionData subscriptionData) {
        this.subscriptionData = subscriptionData;
    }
}
