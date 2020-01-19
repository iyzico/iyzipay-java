package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class UpdateSubscriptionPricingPlanRequest extends Request {

    private String name;
    private Integer trialPeriodDays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrialPeriodDays() {
        return trialPeriodDays;
    }

    public void setTrialPeriodDays(Integer trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }
}
