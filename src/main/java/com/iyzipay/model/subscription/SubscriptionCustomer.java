package com.iyzipay.model.subscription;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResponseResource;
import com.iyzipay.request.subscription.CreateSubscriptionCustomerRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionCustomerRequest;

public class SubscriptionCustomer extends IyzipayResource {

    @SerializedName("data")
    private SubscriptionCustomerResponseResource subscriptionCustomerResponseResource;

    public static SubscriptionCustomer create(CreateSubscriptionCustomerRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers";
        return HttpClient.create().post(uri,
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionCustomer.class);
    }

    public static SubscriptionCustomer update(String subscriptionCustomerReferenceCode, UpdateSubscriptionCustomerRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().post(uri,
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionCustomer.class);
    }

    public static SubscriptionCustomer retrieve(String subscriptionCustomerReferenceCode, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/customers/" + subscriptionCustomerReferenceCode;
        return HttpClient.create().get(uri,
                getHttpHeadersV2(uri, null, options),
                null,
                SubscriptionCustomer.class);
    }

    public SubscriptionCustomerResponseResource getSubscriptionCustomerResponseResource() {
        return subscriptionCustomerResponseResource;
    }

    public void setSubscriptionCustomerResponseResource(SubscriptionCustomerResponseResource subscriptionCustomerResponseResource) {
        this.subscriptionCustomerResponseResource = subscriptionCustomerResponseResource;
    }
}
