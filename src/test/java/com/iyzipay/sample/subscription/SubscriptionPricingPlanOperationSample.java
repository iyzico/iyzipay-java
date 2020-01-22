package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionPricingPlanOperation;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionPricingPlanOperationSample extends Sample {

    @Test
    public void should_delete() {
        //when
        SubscriptionPricingPlanOperation response = SubscriptionPricingPlanOperation.delete("ffa7b210-7990-4a3b-ad2c-e57774e8ec24", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}