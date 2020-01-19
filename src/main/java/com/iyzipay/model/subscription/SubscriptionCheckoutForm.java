package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.CreatedSubscriptionResource;

public class SubscriptionCheckoutForm extends IyzipayResource {

    @SerializedName("data")
    private CreatedSubscriptionResource createdSubscriptionResource;

    public static SubscriptionCheckoutForm retrieveSubscription(String subscriptionCheckoutFormToken, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/checkoutform/" + subscriptionCheckoutFormToken;
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCheckoutForm.class);
    }

    public CreatedSubscriptionResource getCreatedSubscriptionResource() {
        return createdSubscriptionResource;
    }

    public void setCreatedSubscriptionResource(CreatedSubscriptionResource createdSubscriptionResource) {
        this.createdSubscriptionResource = createdSubscriptionResource;
    }
}
