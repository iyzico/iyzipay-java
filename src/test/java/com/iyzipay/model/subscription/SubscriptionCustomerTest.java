package com.iyzipay.model.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Status;
import com.iyzipay.request.subscription.CreateSubscriptionCustomerRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionCustomerRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SubscriptionCustomerTest extends Sample {

    @Test
    public void should_create() {
        //given
        Address address = new Address();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("34742");

        CreateSubscriptionCustomerRequest subscriptionCustomerRequest = new CreateSubscriptionCustomerRequest();
        subscriptionCustomerRequest.setBillingAddress(address);
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setEmail("caner@email.com");
        subscriptionCustomerRequest.setGsmNumber("+905332135678");
        subscriptionCustomerRequest.setShippingAddress(address);
        subscriptionCustomerRequest.setIdentityNumber("21345678902");
        subscriptionCustomerRequest.setName("Caner");
        subscriptionCustomerRequest.setSurname("Yesildag");
        subscriptionCustomerRequest.setConversationId("123456");
        subscriptionCustomerRequest.setLocale("TR");

        //when
        SubscriptionCustomer response = SubscriptionCustomer.create(subscriptionCustomerRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_update() {
        //given
        Address address = new Address();
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
        subscriptionCustomerRequest.setLocale("TR");

        //when
        SubscriptionCustomer response = SubscriptionCustomer.update("1ffb2a89-cf69-4ddd-92ae-a52bd1f7461d", subscriptionCustomerRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_retrieve() {
        //when
        SubscriptionCustomer response = SubscriptionCustomer.retrieve("1ffb2a89-cf69-4ddd-92ae-a52bd1f7461d", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}