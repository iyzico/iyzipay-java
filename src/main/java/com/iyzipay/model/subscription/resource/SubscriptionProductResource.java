package com.iyzipay.model.subscription.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class SubscriptionProductResource {

    private String referenceCode;
    @SerializedName("created_ate")
    private Date createdDate;
    private String name;
    private String description;
    private String status;
    @SerializedName("pricingPlans")
    private List<SubscriptionPricingPlanResource> pricingPlanList;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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

    public List<SubscriptionPricingPlanResource> getPricingPlanList() {
        return pricingPlanList;
    }

    public void setPricingPlanList(List<SubscriptionPricingPlanResource> pricingPlanList) {
        this.pricingPlanList = pricingPlanList;
    }
}
