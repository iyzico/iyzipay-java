package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.PagingRequest;
import com.iyzipay.model.subscription.builder.PageRequestQueryParamBuilder;
import com.iyzipay.model.subscription.resource.SubscriptionProductListData;

public class SubscriptionProductList extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionProductListData subscriptionProductListData;

    public static SubscriptionProductList retrieve(PagingRequest request, Options options) {
        String path = "/v2/subscription/products";
        String uri = options.getBaseUrl() + path + "/" + new PageRequestQueryParamBuilder()
                .page(request.getPage())
                .count(request.getCount())
                .build();
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(path, null, options),
                null,
                SubscriptionProductList.class);
    }

    public SubscriptionProductListData getSubscriptionProductListData() {
        return subscriptionProductListData;
    }

    public void setSubscriptionProductListData(SubscriptionProductListData subscriptionProductListData) {
        this.subscriptionProductListData = subscriptionProductListData;
    }
}
