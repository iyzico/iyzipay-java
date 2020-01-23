package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscriptionProductData {

    private String referenceCode;
    private String createdDate;
    private String name;
    private String description;
    private String status;
    @SerializedName("pricingPlans")
    private List<SubscriptionPricingPlanData> pricingPlanList;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SubscriptionPricingPlanData> getPricingPlanList() {
        return pricingPlanList;
    }

    public void setPricingPlanList(List<SubscriptionPricingPlanData> pricingPlanList) {
        this.pricingPlanList = pricingPlanList;
    }
}
