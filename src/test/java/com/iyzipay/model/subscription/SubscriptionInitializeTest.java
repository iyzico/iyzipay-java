package com.iyzipay.model.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.resource.SubscriptionCardResource;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.request.subscription.InitializeSubscriptionRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SubscriptionInitializeTest extends Sample {

    @Test
    public void should_create() {
        //given

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
        subscriptionCustomerResource.setIdentityNumber("111111");
        subscriptionCustomerResource.setGsmNumber("+905381111111");
        subscriptionCustomerResource.setBillingAddress(address);
        subscriptionCustomerResource.setShippingAddress(address);

        SubscriptionCardResource paymentCard = new SubscriptionCardResource();
        paymentCard.setCardHolderName("erhan mutlu");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setCardUserKey("DjK3HK7qk3MTVoD1+50b4GhRji4=");
        paymentCard.setCardToken("RavPqCEEPASort9NZRohjgd1FXw=");

        InitializeSubscriptionRequest initializeSubscriptionRequest = new InitializeSubscriptionRequest();
        initializeSubscriptionRequest.setPaymentCard(paymentCard);
        initializeSubscriptionRequest.setPricingPlanReferenceCode("553d006c-da91-46d3-81a4-8297881d6b9e");
        initializeSubscriptionRequest.setSubscriptionCustomerResource(subscriptionCustomerResource);
        initializeSubscriptionRequest.setSubscriptionInitialStatus("ACTIVE");
        initializeSubscriptionRequest.setConversationId("12345");
        initializeSubscriptionRequest.setLocale("TR");

        //when
        SubscriptionInitialize response = SubscriptionInitialize.create(initializeSubscriptionRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_create_with_existing_customer() {
        //given

        //when

        //then

    }
}