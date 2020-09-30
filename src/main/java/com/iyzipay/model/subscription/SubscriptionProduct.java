package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionProductData;
import com.iyzipay.request.subscription.CreateSubscriptionProductRequest;
import com.iyzipay.request.subscription.SubscriptionUpdateProductRequest;

public class SubscriptionProduct extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionProductData subscriptionProductData;

    public static SubscriptionProduct retrieve(String subscriptionProductReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionProduct.class);
    }

    public static SubscriptionProduct create(CreateSubscriptionProductRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionProduct.class);
    }

    public static SubscriptionProduct update(String subscriptionProductReferenceCode, SubscriptionUpdateProductRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionProduct.class);
    }

    public static IyzipayResource delete(String subscriptionProductReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionProductReferenceCode;
        return HttpClient.create().delete(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                IyzipayResource.class);
    }

    public SubscriptionProductData getSubscriptionProductData() {
        return subscriptionProductData;
    }

    public void setSubscriptionProductData(SubscriptionProductData subscriptionProductData) {
        this.subscriptionProductData = subscriptionProductData;
    }
}
