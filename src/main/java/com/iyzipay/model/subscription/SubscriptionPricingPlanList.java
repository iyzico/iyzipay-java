package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.PagingRequest;
import com.iyzipay.model.subscription.builder.PageRequestQueryParamBuilder;
import com.iyzipay.model.subscription.resource.SubscriptionPricingPlanListData;

public class SubscriptionPricingPlanList extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionPricingPlanListData subscriptionPricingPlanListData;

    public static SubscriptionPricingPlanList retrieve(String subscriptionPricingPlanReferenceCode, PagingRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionPricingPlanReferenceCode + "/pricing-plans/" + new PageRequestQueryParamBuilder()
                .page(request.getPage())
                .count(request.getCount())
                .build();
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionPricingPlanList.class);
    }

    public SubscriptionPricingPlanListData getSubscriptionPricingPlanListData() {
        return subscriptionPricingPlanListData;
    }

    public void setSubscriptionPricingPlanListData(SubscriptionPricingPlanListData subscriptionPricingPlanListData) {
        this.subscriptionPricingPlanListData = subscriptionPricingPlanListData;
    }
}
