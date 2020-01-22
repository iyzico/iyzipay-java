package com.iyzipay.request.subscription;

import com.iyzipay.Request;
import com.iyzipay.model.subscription.resource.SubscriptionCardResource;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;

public class InitializeSubscriptionRequest extends Request {

    private SubscriptionCardResource paymentCard;
    private SubscriptionCustomerResource customer;
    private String pricingPlanReferenceCode;
    private String subscriptionInitialStatus;

    public SubscriptionCardResource getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(SubscriptionCardResource paymentCard) {
        this.paymentCard = paymentCard;
    }

    public SubscriptionCustomerResource getCustomer() {
        return customer;
    }

    public void setCustomer(SubscriptionCustomerResource customer) {
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
