package com.iyzipay.model.loyalty;

import com.iyzipay.ToStringRequestBuilder;

import java.math.BigDecimal;

public class Loyalty {

    private BigDecimal rewardAmount;
    private Integer rewardUsage;

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Integer getRewardUsage() {
        return rewardUsage;
    }

    public void setRewardUsage(Integer rewardUsage) {
        this.rewardUsage = rewardUsage;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("rewardAmount", rewardAmount)
                .append("rewardUsage", rewardUsage)
                .toString();
    }
}
