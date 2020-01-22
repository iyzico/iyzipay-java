package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionProductOperation;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionProductOperationSample extends Sample {

    @Test
    public void should_delete() {
        SubscriptionProductOperation response = SubscriptionProductOperation.delete("5389bdf2-9ddd-4555-a199-c93f82efec84", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}