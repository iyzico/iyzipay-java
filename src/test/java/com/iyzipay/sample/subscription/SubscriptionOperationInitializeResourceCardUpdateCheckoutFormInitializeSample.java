package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCheckoutForm;
import com.iyzipay.request.subscription.InitializeSubscriptionCardUpdateCheckoutFormRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionOperationInitializeResourceCardUpdateCheckoutFormInitializeSample extends Sample {

//    @Test
//    public void should_init_subscription_checkoutForm() {
//        InitializeSubscriptionCardUpdateCheckoutFormRequest request = new InitializeSubscriptionCardUpdateCheckoutFormRequest();
//        request.setCustomerReferenceCode("customer-reference-code");
//        request.setCallbackUrl("http://iyzico.com");
//
//        SubscriptionCheckoutForm response = SubscriptionCheckoutForm.initializeCardUpdate(request, options);
//
//        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
//        assertEquals(Locale.TR.getValue(), response.getLocale());
//        assertNotNull(response.getToken());
//        assertNotNull(response.getCheckoutFormContent());
//        assertNotNull(response.getTokenExpireTime());
//    }
}
