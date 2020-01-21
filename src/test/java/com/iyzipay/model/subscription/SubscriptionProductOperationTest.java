package com.iyzipay.model.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionProductOperationTest extends Sample {

    @Test
    public void should_delete() {
        //when
        SubscriptionProductOperation response = SubscriptionProductOperation.delete("5389bdf2-9ddd-4555-a199-c93f82efec84", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}