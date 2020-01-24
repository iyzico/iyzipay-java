package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionPaymentType {

    RECURRING(1);

    private final Integer value;

    SubscriptionPaymentType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
