package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionPricingPlanData;
import com.iyzipay.request.subscription.CreateSubscriptionPricingPlanRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionPricingPlanRequest;

public class SubscriptionPricingPlan extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionPricingPlanData subscriptionPricingPlanData;

    public static SubscriptionPricingPlan retrieve(String subscriptionPricingPlanReferenceCode, Options options) {
        String path = "/v2/subscription/pricing-plans/" + subscriptionPricingPlanReferenceCode;;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                SubscriptionPricingPlan.class);
    }

    public static SubscriptionPricingPlan create(String subscriptionProductReferenceCode, CreateSubscriptionPricingPlanRequest request, Options options) {
        String path = "/v2/subscription/products/" + subscriptionProductReferenceCode + "/pricing-plans";
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubscriptionPricingPlan.class);
    }

    public static SubscriptionPricingPlan update(String subscriptionPricingPlanReferenceCode, UpdateSubscriptionPricingPlanRequest request, Options options) {
        String path = "/v2/subscription/pricing-plans/" + subscriptionPricingPlanReferenceCode;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                SubscriptionPricingPlan.class);
    }

    public static IyzipayResource delete(String subscriptionPricingPlanReferenceCode, Options options) {
        String path = "/v2/subscription/pricing-plans/" + subscriptionPricingPlanReferenceCode;
        String uri = options.getBaseUrl() + path;
        return HttpClient.create().delete(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                IyzipayResource.class);
    }

    public SubscriptionPricingPlanData getSubscriptionPricingPlanData() {
        return subscriptionPricingPlanData;
    }

    public void setSubscriptionPricingPlanData(SubscriptionPricingPlanData subscriptionPricingPlanData) {
        this.subscriptionPricingPlanData = subscriptionPricingPlanData;
    }
}
