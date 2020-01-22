package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.Subscription;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionSample extends Sample {

    @Test
    public void should_retrieve_subscription() {
        //when
        Subscription response = Subscription.retrieve("6081cea6-fae5-45f0-9f9e-2c979259f0a7", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}