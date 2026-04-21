package com.iyzipay.request.subscription;

import com.iyzipay.Request;

public class DeleteSubscriptionPricingPlanRequest extends Request {

    private String pricingPlanReferenceCode;

    public String getPricingPlanReferenceCode() {
        return pricingPlanReferenceCode;
    }

    public void setPricingPlanReferenceCode(String pricingPlanReferenceCode) {
        this.pricingPlanReferenceCode = pricingPlanReferenceCode;
    }
}
