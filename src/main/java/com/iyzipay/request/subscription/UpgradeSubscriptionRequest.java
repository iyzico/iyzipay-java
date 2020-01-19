package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class UpgradeSubscriptionRequest extends Request {

    private String newPricingPlanReferenceCode;
    private String upgradePeriod;
    private Boolean useTrial;
    private Boolean resetRecurrenceCount;

    public String getNewPricingPlanReferenceCode() {
        return newPricingPlanReferenceCode;
    }

    public void setNewPricingPlanReferenceCode(String newPricingPlanReferenceCode) {
        this.newPricingPlanReferenceCode = newPricingPlanReferenceCode;
    }

    public String getUpgradePeriod() {
        return upgradePeriod;
    }

    public void setUpgradePeriod(String upgradePeriod) {
        this.upgradePeriod = upgradePeriod;
    }

    public Boolean getUseTrial() {
        return useTrial;
    }

    public void setUseTrial(Boolean useTrial) {
        this.useTrial = useTrial;
    }

    public Boolean getResetRecurrenceCount() {
        return resetRecurrenceCount;
    }

    public void setResetRecurrenceCount(Boolean resetRecurrenceCount) {
        this.resetRecurrenceCount = resetRecurrenceCount;
    }
}
