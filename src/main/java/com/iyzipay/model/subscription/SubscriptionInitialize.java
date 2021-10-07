package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.CreatedSubscriptionData;
import com.iyzipay.request.subscription.InitializeSubscriptionRequest;
import com.iyzipay.request.subscription.InitializeSubscriptionWithExistingCustomerRequest;

public class SubscriptionInitialize extends IyzipayResource {

    @SerializedName("data")
    private CreatedSubscriptionData createdSubscriptionData;

    public static SubscriptionInitialize create(InitializeSubscriptionRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/initialize";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionInitialize.class);
    }

    public static SubscriptionInitialize createWithExistingCustomer(InitializeSubscriptionWithExistingCustomerRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/initialize/with-customer";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionInitialize.class);
    }

    public CreatedSubscriptionData getCreatedSubscriptionData() {
        return createdSubscriptionData;
    }

    public void setCreatedSubscriptionData(CreatedSubscriptionData createdSubscriptionData) {
        this.createdSubscriptionData = createdSubscriptionData;
    }
}
