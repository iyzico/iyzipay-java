package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionUpgradePeriod {

    NOW(1),
    NEXT_PERIOD(2);

    private final Integer value;

    SubscriptionUpgradePeriod(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
