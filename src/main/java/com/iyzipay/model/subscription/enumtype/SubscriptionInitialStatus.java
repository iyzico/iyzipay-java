package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionInitialStatus {

    ACTIVE(1),
    PENDING(2);

    private final Integer value;

    SubscriptionInitialStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
