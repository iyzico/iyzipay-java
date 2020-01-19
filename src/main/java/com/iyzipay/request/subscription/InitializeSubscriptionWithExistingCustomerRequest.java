package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class InitializeSubscriptionWithExistingCustomerRequest extends Request {

    private String pricingPlanReferenceCode;
    private String customerReferenceCode;
    private String subscriptionInitialStatus;

    public String getPricingPlanReferenceCode() {
        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {
        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }

    public String getCustomerReferenceCode() {
        return customerReferenceCode;
    }

    public void setCustomerReferenceCode(String customerReferenceCode) {
        this.customerReferenceCode = customerReferenceCode;
    }

    public String getSubscriptionInitialStatus() {
        return subscriptionInitialStatus;
    }

    public void setSubscriptionInitialStatus(String subscriptionInitialStatus) {
        this.subscriptionInitialStatus = subscriptionInitialStatus;
    }
}
