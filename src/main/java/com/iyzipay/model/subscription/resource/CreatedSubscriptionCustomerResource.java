package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

public class CreatedSubscriptionCustomerResource {

    @SerializedName("data")
    private SubscriptionCustomerResponseResource subscriptionCustomerResponseResource;

    public SubscriptionCustomerResponseResource getSubscriptionCustomerResponseResource() {
        return subscriptionCustomerResponseResource;
    }

    public void setSubscriptionCustomerResponseResource(SubscriptionCustomerResponseResource subscriptionCustomerResponseResource) {
        this.subscriptionCustomerResponseResource = subscriptionCustomerResponseResource;
    }
}
