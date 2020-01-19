package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.PagingRequest;
import com.iyzipay.model.subscription.builder.PageRequestQueryParamBuilder;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerListResource;

public class SubscriptionCustomerList extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionCustomerListResource subscriptionCustomerListResource;

    public static SubscriptionCustomerList retrieve(PagingRequest request, Options options){
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + new PageRequestQueryParamBuilder()
                .page(request.getPage())
                .count(request.getCount())
                .build();
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCustomerList.class);
    }
}
