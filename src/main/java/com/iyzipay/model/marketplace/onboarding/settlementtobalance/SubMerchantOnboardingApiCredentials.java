package com.iyzipay.model.marketplace.onboarding.settlementtobalance;

public class SubMerchantOnboardingApiCredentials {
    private String salt;
    private String secretKey;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
