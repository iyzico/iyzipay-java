package com.iyzipay.request.subscription;

import com.iyzipay.Request;
import com.iyzipay.model.subscription.resource.SubscriptionCustomer;

public class InitializeSubscriptionCheckoutFormRequest extends Request {

    private String callbackUrl;
    private String pricingPlanReferenceCode;
    private String subscriptionInitialStatus;
    private SubscriptionCustomer customer;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPricingPlanReferenceCode() {
        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {
        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }

    public String getSubscriptionInitialStatus() {
        return subscriptionInitialStatus;
    }

    public void setSubscriptionInitialStatus(String subscriptionInitialStatus) {
        this.subscriptionInitialStatus = subscriptionInitialStatus;
    }

    public SubscriptionCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SubscriptionCustomer customer) {
        this.customer = customer;
    }
}
