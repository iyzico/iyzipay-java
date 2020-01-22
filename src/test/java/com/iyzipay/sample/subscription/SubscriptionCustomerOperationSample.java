package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCustomerOperation;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SubscriptionCustomerOperationSample extends Sample {

    @Test
    public void should_delete() {
        SubscriptionCustomerOperation response = SubscriptionCustomerOperation.delete("1ffb2a89-cf69-4ddd-92ae-a52bd1f7461d", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}