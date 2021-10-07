package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.CreatedSubscriptionData;

public class SubscriptionCheckoutForm extends IyzipayResource {

    @SerializedName("data")
    private CreatedSubscriptionData createdSubscriptionData;

    public static SubscriptionCheckoutForm retrieve(String subscriptionCheckoutFormToken, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/checkoutform/" + subscriptionCheckoutFormToken;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCheckoutForm.class);
    }

    public CreatedSubscriptionData getCreatedSubscriptionData() {
        return createdSubscriptionData;
    }

    public void setCreatedSubscriptionData(CreatedSubscriptionData createdSubscriptionData) {
        this.createdSubscriptionData = createdSubscriptionData;
    }
}
