package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionPaymentInterval {

    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    YEARLY(4);

    private final Integer value;

    SubscriptionPaymentInterval(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
