package com.iyzipay.sample.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCheckoutForm;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SubscriptionCheckoutFormSample extends Sample {

    @Test
    public void should_retrieve_subscription_checkout_form() {
        SubscriptionCheckoutForm response = SubscriptionCheckoutForm.retrieve("044513be-33ad-493b-b3ec-66591fce4988", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}