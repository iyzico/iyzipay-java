package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionResource;

public class Subscription extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionResource subscriptionResource;

    public static Subscription retrieve(String subscriptionReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/subscriptions/"+ subscriptionReferenceCode;
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                Subscription.class);
    }

    public SubscriptionResource getSubscriptionResource() {
        return subscriptionResource;
    }

    public void setSubscriptionResource(SubscriptionResource subscriptionResource) {
        this.subscriptionResource = subscriptionResource;
    }
}
