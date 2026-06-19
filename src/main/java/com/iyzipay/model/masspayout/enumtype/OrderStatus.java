package com.iyzipay.model.masspayout.enumtype;

public enum OrderStatus {
    INVALID(-2),
    FAILED(-1),
    SUCCESS(1),
    INIT(2),
    PROCESSING(3),
    MASS_PAYOUT_CANCELED(5),
    QUEUED(6),
    DEPOSIT_SUCCESS(7),
    DEPOSIT_FAIL(8);

    private final Integer value;

    OrderStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

