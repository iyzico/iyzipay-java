package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionOrderData;

public class SubscriptionOrder extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionOrderData subscriptionOrderData;

    public static SubscriptionOrder retrieve(String subscriptionOrderReferenceCode, Options options) {
        String path = "/v2/subscription/orders/" + subscriptionOrderReferenceCode;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                SubscriptionOrder.class);
    }

    public SubscriptionOrderData getSubscriptionOrderData() {
        return subscriptionOrderData;
    }

    public void setSubscriptionOrderData(SubscriptionOrderData subscriptionOrderData) {
        this.subscriptionOrderData = subscriptionOrderData;
    }
}
