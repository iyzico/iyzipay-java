package com.iyzipay.model;

public enum MassPayoutStatus {
    INIT(1),
    IN_PROGRESS(2),
    SUCCESS(3),
    COMPLETED(5),
    FAIL(-1),
    INSUFFICIENT_BALANCE(-2),
    CANCELED(-3),
    IYZICO_INSUFFICIENT_BALANCE(-4);

    private final Integer value;

    MassPayoutStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
