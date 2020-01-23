package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionPaymentStatus {

    FAILED(-1),
    SUCCESS(1),
    PROCESSING(3);

    private final Integer value;

    SubscriptionPaymentStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
