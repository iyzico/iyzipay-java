package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionOrder;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionOrderSample extends Sample {

    @Test
    public void should_retrieve() {
        SubscriptionOrder response = SubscriptionOrder.retrieve("83d90303-737e-43e2-932e-059f1ff19b40", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}