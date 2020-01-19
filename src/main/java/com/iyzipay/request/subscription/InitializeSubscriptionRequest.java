package com.iyzipay.request.subscription;

import com.iyzipay.Request;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.model.subscription.resource.SubscriptionCardResource;

public class InitializeSubscriptionRequest extends Request {

    private SubscriptionCardResource paymentCard;
    private SubscriptionCustomerResource subscriptionCustomerResource;
    private String pricingPlanReferenceCode;
    private String subscriptionInitialStatus;

    public SubscriptionCardResource getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(SubscriptionCardResource paymentCard) {
        this.paymentCard = paymentCard;
    }

    public SubscriptionCustomerResource getSubscriptionCustomerResource() {
        return subscriptionCustomerResource;
    }

    public void setSubscriptionCustomerResource(SubscriptionCustomerResource subscriptionCustomerResource) {
        this.subscriptionCustomerResource = subscriptionCustomerResource;
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
}
