package com.iyzipay.request.subscription;

import com.iyzipay.Request;
import com.iyzipay.model.subscription.resource.SubscriptionCardData;
import com.iyzipay.model.subscription.resource.SubscriptionCustomer;

public class InitializeSubscriptionRequest extends Request {

    private SubscriptionCardData paymentCard;
    private SubscriptionCustomer customer;
    private String pricingPlanReferenceCode;
    private String subscriptionInitialStatus;

    public SubscriptionCardData getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(SubscriptionCardData paymentCard) {
        this.paymentCard = paymentCard;
    }

    public SubscriptionCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SubscriptionCustomer customer) {
        this.customer = customer;
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
