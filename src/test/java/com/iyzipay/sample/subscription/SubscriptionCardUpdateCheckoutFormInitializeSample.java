package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCardUpdateCheckoutFormInitialize;
import com.iyzipay.request.subscription.InitializeSubscriptionCardUpdateCheckoutFormRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionCardUpdateCheckoutFormInitializeSample extends Sample {

    @Test
    public void should_initialize_subscription_card_update_checkout_form() {
        InitializeSubscriptionCardUpdateCheckoutFormRequest cardUpdateCheckoutFormRequest = new InitializeSubscriptionCardUpdateCheckoutFormRequest();
        cardUpdateCheckoutFormRequest.setCallbackUrl("https://www.merchant.com/callback");
        cardUpdateCheckoutFormRequest.setCustomerReferenceCode("dfc1d5d2-1859-4582-9889-30f9c409d86f");
        cardUpdateCheckoutFormRequest.setConversationId("123456");
        cardUpdateCheckoutFormRequest.setLocale(Locale.TR.name());

        SubscriptionCardUpdateCheckoutFormInitialize response = SubscriptionCardUpdateCheckoutFormInitialize.create(cardUpdateCheckoutFormRequest, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
    }
}