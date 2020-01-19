package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.PagingRequest;
import com.iyzipay.model.subscription.builder.PageRequestQueryParamBuilder;
import com.iyzipay.model.subscription.resource.SubscriptionPricingPlanListResource;

public class SubscriptionPricingPlanList extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionPricingPlanListResource subscriptionPricingPlanListResource;

    public static SubscriptionPricingPlanList retrieve(String subscriptionPricingPlanReferenceCode, PagingRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/products/" + subscriptionPricingPlanReferenceCode + "/pricing-plans/" + new PageRequestQueryParamBuilder()
                .page(request.getPage())
                .count(request.getCount())
                .build();
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionPricingPlanList.class);
    }

    public SubscriptionPricingPlanListResource getSubscriptionPricingPlanListResource() {
        return subscriptionPricingPlanListResource;
    }

    public void setSubscriptionPricingPlanListResource(SubscriptionPricingPlanListResource subscriptionPricingPlanListResource) {
        this.subscriptionPricingPlanListResource = subscriptionPricingPlanListResource;
    }
}
