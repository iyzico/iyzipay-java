package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionProductResource;
import com.iyzipay.request.subscription.CreateSubscriptionProductRequest;
import com.iyzipay.request.subscription.SubscriptionUpdateProductRequest;

public class SubscriptionProduct extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionProductResource subscriptionProductResource;

    public static SubscriptionProduct retrieve(String subscriptionProductReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionProduct.class);
    }

    public static SubscriptionProduct create(CreateSubscriptionProductRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products";
        return HttpClient.create().post(uri,
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionProduct.class);
    }

    public static SubscriptionProduct update(String subscriptionProductReferenceCode, SubscriptionUpdateProductRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().post(uri,
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionProduct.class);
    }

    public SubscriptionProductResource getSubscriptionProductResource() {
        return subscriptionProductResource;
    }

    public void setSubscriptionProductResource(SubscriptionProductResource subscriptionProductResource) {
        this.subscriptionProductResource = subscriptionProductResource;
    }
}
