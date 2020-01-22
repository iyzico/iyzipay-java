package com.iyzipay.sample.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionInitialize;
import com.iyzipay.model.subscription.enumtype.SubscriptionInitialStatus;
import com.iyzipay.model.subscription.resource.SubscriptionCardResource;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.model.subscription.resource.SubscriptionStatus;
import com.iyzipay.request.subscription.InitializeSubscriptionRequest;
import com.iyzipay.request.subscription.InitializeSubscriptionWithExistingCustomerRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SubscriptionInitializeSample extends Sample {

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
        paymentCard.setCardHolderName("caner yesildag");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");

        InitializeSubscriptionRequest initializeSubscriptionRequest = new InitializeSubscriptionRequest();
        initializeSubscriptionRequest.setPaymentCard(paymentCard);
        initializeSubscriptionRequest.setPricingPlanReferenceCode("553d006c-da91-46d3-81a4-8297881d6b9e");
        initializeSubscriptionRequest.setCustomer(subscriptionCustomerResource);
        initializeSubscriptionRequest.setSubscriptionInitialStatus(SubscriptionInitialStatus.ACTIVE.name());
        initializeSubscriptionRequest.setConversationId("12345");
        initializeSubscriptionRequest.setLocale(Locale.TR.name());

        //when
        SubscriptionInitialize response = SubscriptionInitialize.create(initializeSubscriptionRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getCreatedSubscriptionResource().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getCreatedDate());
        assertNotNull(response.getCreatedSubscriptionResource().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getParentReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getStartDate());
        assertNotNull(response.getCreatedSubscriptionResource().getTrialStartDate());
        assertNotNull(response.getCreatedSubscriptionResource().getEndDate());
        assertNotNull(response.getCreatedSubscriptionResource().getTrialEndDate());
        assertNotNull(response.getCreatedSubscriptionResource().getTrialDays());
        assertEquals(response.getCreatedSubscriptionResource().getPricingPlanReferenceCode(), "553d006c-da91-46d3-81a4-8297881d6b9e");
        assertEquals(response.getCreatedSubscriptionResource().getSubscriptionStatus(), SubscriptionStatus.ACTIVE.name());
    }

    @Test
    public void should_create_with_existing_customer() {
        //given
        InitializeSubscriptionWithExistingCustomerRequest initializeSubscriptionWithExistingCustomerRequest = new InitializeSubscriptionWithExistingCustomerRequest();
        initializeSubscriptionWithExistingCustomerRequest.setCustomerReferenceCode("dfc1d5d2-1859-4582-9889-30f9c409d86f");
        initializeSubscriptionWithExistingCustomerRequest.setPricingPlanReferenceCode("553d006c-da91-46d3-81a4-8297881d6b9e");
        initializeSubscriptionWithExistingCustomerRequest.setSubscriptionInitialStatus(SubscriptionInitialStatus.PENDING.name());
        initializeSubscriptionWithExistingCustomerRequest.setConversationId("12345");
        initializeSubscriptionWithExistingCustomerRequest.setLocale(Locale.TR.name());

        //when
        SubscriptionInitialize response = SubscriptionInitialize.createWithExistingCustomer(initializeSubscriptionWithExistingCustomerRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getCreatedSubscriptionResource().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getCreatedDate());
        assertEquals(response.getCreatedSubscriptionResource().getCustomerReferenceCode(), "dfc1d5d2-1859-4582-9889-30f9c409d86f");
        assertNotNull(response.getCreatedSubscriptionResource().getParentReferenceCode());
        assertNotNull(response.getCreatedSubscriptionResource().getReferenceCode());
        assertEquals(response.getCreatedSubscriptionResource().getPricingPlanReferenceCode(), "553d006c-da91-46d3-81a4-8297881d6b9e");
        assertEquals(response.getCreatedSubscriptionResource().getSubscriptionStatus(), SubscriptionStatus.PENDING.name());
    }
}