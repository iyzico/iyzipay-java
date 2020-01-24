package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionOrderStatus {

    MERCHANT_SUSPENDED(-99),
    FAILED(-1),
    SUCCESS(1),
    WAITING(2),
    PROCESSING(3),
    SUBSCRIPTION_UPGRADED(4),
    SUBSCRIPTION_CANCELED(5),
    QUEUED(6);

    private final Integer value;

    SubscriptionOrderStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
