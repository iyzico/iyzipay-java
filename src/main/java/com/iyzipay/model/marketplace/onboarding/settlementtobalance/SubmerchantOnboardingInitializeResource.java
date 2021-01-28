package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

import com.iyzipay.IyzipayResource;

public class SubmerchantOnboardingInitializeResource extends IyzipayResource {
    private String txId;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
}
