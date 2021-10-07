package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerData;
import com.iyzipay.request.subscription.CreateSubscriptionCustomerRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionCustomerRequest;

public class SubscriptionCustomer extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionCustomerData subscriptionCustomerData;

    public static SubscriptionCustomer create(CreateSubscriptionCustomerRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionCustomer.class);
    }

    public static SubscriptionCustomer update(String subscriptionCustomerReferenceCode, UpdateSubscriptionCustomerRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionCustomer.class);
    }

    public static SubscriptionCustomer retrieve(String subscriptionCustomerReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().get(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCustomer.class);
    }

    public static IyzipayResource delete(String subscriptionCustomerReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().delete(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, null, options),
                null,
                IyzipayResource.class);
    }

    public SubscriptionCustomerData getSubscriptionCustomerData() {
        return subscriptionCustomerData;
    }

    public void setSubscriptionCustomerData(SubscriptionCustomerData subscriptionCustomerData) {
        this.subscriptionCustomerData = subscriptionCustomerData;
    }
}
