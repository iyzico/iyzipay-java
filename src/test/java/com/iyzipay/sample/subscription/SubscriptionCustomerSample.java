package com.iyzipay.sample.subscription;

import com.iyzipay.IyzipayResource;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.SubscriptionAddress;
import com.iyzipay.model.subscription.SubscriptionCustomer;
import com.iyzipay.request.subscription.CreateSubscriptionCustomerRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionCustomerRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SubscriptionCustomerSample extends Sample {

    @Test
    public void should_create() {
        SubscriptionAddress address = new SubscriptionAddress();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("34742");

        CreateSubscriptionCustomerRequest subscriptionCustomerRequest = new CreateSubscriptionCustomerRequest();
        subscriptionCustomerRequest.setBillingAddress(address);
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setEmail("caner@email.com");
        subscriptionCustomerRequest.setGsmNumber("+905332135670");
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setIdentityNumber("21345678992");
        subscriptionCustomerRequest.setName("Caner");
        subscriptionCustomerRequest.setSurname("Yesildag");
        subscriptionCustomerRequest.setConversationId("123456");
        subscriptionCustomerRequest.setLocale(Locale.TR.name());

        SubscriptionCustomer response = SubscriptionCustomer.create(subscriptionCustomerRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionCustomerData().getBillingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getShippingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getCreatedDate());
        assertNotNull(response.getSubscriptionCustomerData().getEmail());
        assertNotNull(response.getSubscriptionCustomerData().getGsmNumber());
        assertNotNull(response.getSubscriptionCustomerData().getIdentityNumber());
        assertNotNull(response.getSubscriptionCustomerData().getName());
        assertNotNull(response.getSubscriptionCustomerData().getReferenceCode());
        assertNotNull(response.getSubscriptionCustomerData().getSurname());
    }

    @Test
    public void should_update() {
        SubscriptionAddress address = new SubscriptionAddress();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("34742");

        UpdateSubscriptionCustomerRequest subscriptionCustomerRequest = new UpdateSubscriptionCustomerRequest();
        subscriptionCustomerRequest.setBillingAddress(address);
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setEmail("caner@email.com");
        subscriptionCustomerRequest.setGsmNumber("+905332135678");
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setIdentityNumber("21345678902");
        subscriptionCustomerRequest.setName("Caner");
        subscriptionCustomerRequest.setSurname("Yesildag-updated");
        subscriptionCustomerRequest.setConversationId("123456");
        subscriptionCustomerRequest.setLocale(Locale.TR.name());

        SubscriptionCustomer response = SubscriptionCustomer.update("1ffb2a89-cf69-4ddd-92ae-a52bd1f7461d", subscriptionCustomerRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionCustomerData().getBillingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getShippingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getCreatedDate());
        assertNotNull(response.getSubscriptionCustomerData().getEmail());
        assertNotNull(response.getSubscriptionCustomerData().getGsmNumber());
        assertNotNull(response.getSubscriptionCustomerData().getIdentityNumber());
        assertNotNull(response.getSubscriptionCustomerData().getName());
        assertNotNull(response.getSubscriptionCustomerData().getReferenceCode());
        assertNotNull(response.getSubscriptionCustomerData().getSurname());
    }

    @Test
    public void should_retrieve() {
        SubscriptionCustomer response = SubscriptionCustomer.retrieve("d6797c6d-b99d-417c-bffc-aa931173f0ef", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionCustomerData().getBillingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getShippingAddress());
        assertNotNull(response.getSubscriptionCustomerData().getCreatedDate());
        assertNotNull(response.getSubscriptionCustomerData().getEmail());
        assertNotNull(response.getSubscriptionCustomerData().getGsmNumber());
        assertNotNull(response.getSubscriptionCustomerData().getIdentityNumber());
        assertNotNull(response.getSubscriptionCustomerData().getName());
        assertNotNull(response.getSubscriptionCustomerData().getReferenceCode());
        assertNotNull(response.getSubscriptionCustomerData().getSurname());
    }

    @Test
    public void should_delete() {
        IyzipayResource response = SubscriptionCustomer.delete("1ffb2a89-cf69-4ddd-92ae-a52bd1f7461d", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}