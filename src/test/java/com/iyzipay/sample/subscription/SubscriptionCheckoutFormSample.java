package com.iyzipay.sample.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCheckoutFormInitialize;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.model.subscription.resource.SubscriptionStatus;
import com.iyzipay.request.subscription.InitializeSubscriptionCheckoutFormRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionCheckoutFormSample extends Sample {

    @Test
    public void should_init_subscription_checkoutForm() {
        InitializeSubscriptionCheckoutFormRequest request = new InitializeSubscriptionCheckoutFormRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPricingPlanReferenceCode("ffa7b210-7990-4a3b-ad2c-e57774e8ec24");
        request.setSubscriptionInitialStatus(SubscriptionStatus.PENDING.name());
        request.setCallbackUrl("callbackUrl");

        Address address = new Address();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("34742");

        SubscriptionCustomerResource subscriptionCustomerResource = new SubscriptionCustomerResource();
        subscriptionCustomerResource.setName("John");
        subscriptionCustomerResource.setSurname("Doe");
        subscriptionCustomerResource.setEmail("test@mail.com");
        subscriptionCustomerResource.setIdentityNumber("11111111111");
        subscriptionCustomerResource.setGsmNumber("+905350000000");
        subscriptionCustomerResource.setBillingAddress(address);
        subscriptionCustomerResource.setShippingAddress(address);
        request.setSubscriptionCustomerResource(subscriptionCustomerResource);

        SubscriptionCheckoutFormInitialize response = SubscriptionCheckoutFormInitialize.create(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertNotNull(response.getToken());
        assertNotNull(response.getCheckoutFormContent());
        assertNotNull(response.getTokenExpireTime());
    }
}