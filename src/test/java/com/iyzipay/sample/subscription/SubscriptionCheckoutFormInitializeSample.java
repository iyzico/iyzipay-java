package com.iyzipay.sample.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionCheckoutFormInitialize;
import com.iyzipay.model.subscription.enumtype.SubscriptionInitialStatus;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.request.subscription.InitializeSubscriptionCheckoutFormRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionCheckoutFormInitializeSample extends Sample {

    @Test
    public void should_init_subscription_checkoutForm() {
        Address address = new Address();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("347");

        SubscriptionCustomerResource customer = new SubscriptionCustomerResource();
        customer.setBillingAddress(address);
        customer.setShippingAddress(address);
        customer.setEmail("caner@email.com");
        customer.setGsmNumber("+905432789543");
        customer.setIdentityNumber("12345678901");
        customer.setName("Caner");
        customer.setSurname("Test");

        InitializeSubscriptionCheckoutFormRequest request = new InitializeSubscriptionCheckoutFormRequest();
        request.setCustomer(customer);
        request.setCallbackUrl("www.google.com");
        request.setPricingPlanReferenceCode("23893e87-ef29-4b96-936f-e50ffce1f362");
        request.setSubscriptionInitialStatus(SubscriptionInitialStatus.ACTIVE.name());
        request.setConversationId("12345");
        request.setLocale(Locale.TR.name());

        SubscriptionCheckoutFormInitialize response = SubscriptionCheckoutFormInitialize.create(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertNotNull(response.getToken());
        assertNotNull(response.getCheckoutFormContent());
        assertNotNull(response.getTokenExpireTime());
    }
}
