package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionPayment;
import com.iyzipay.request.subscription.SubscriptionOrderOperationRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionPaymentSample extends Sample {

    @Test
    public void should_retry_payment() {
        SubscriptionOrderOperationRequest subscriptionOrderOperationRequest = new SubscriptionOrderOperationRequest();
        subscriptionOrderOperationRequest.setReferenceCode("cd6fa908-42af-47e6-9eef-5311fd2b9b32");
        subscriptionOrderOperationRequest.setConversationId("123456");
        subscriptionOrderOperationRequest.setLocale(Locale.TR.name());

        SubscriptionPayment response = SubscriptionPayment.retry(subscriptionOrderOperationRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}