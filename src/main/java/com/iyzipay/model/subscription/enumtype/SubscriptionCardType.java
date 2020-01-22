package com.iyzipay.model.subscription.enumtype;

public enum SubscriptionCardType {

    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    PREPAID_CARD("PREPAID_CARD");

    private final String value;

    SubscriptionCardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
