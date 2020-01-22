package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionProductType {

    UNKNOWN(-1),
    PHYSICAL(1),
    VIRTUAL(2);

    private final Integer value;

    SubscriptionProductType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
