package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.SubscriptionAddress;
import com.iyzipay.model.subscription.SubscriptionInitialize;
import com.iyzipay.model.subscription.enumtype.SubscriptionInitialStatus;
import com.iyzipay.model.subscription.enumtype.SubscriptionStatus;
import com.iyzipay.model.subscription.resource.SubscriptionCardData;
import com.iyzipay.model.subscription.resource.SubscriptionCustomer;
import com.iyzipay.request.subscription.InitializeSubscriptionRequest;
import com.iyzipay.request.subscription.InitializeSubscriptionWithExistingCustomerRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SubscriptionInitializeSample extends Sample {

    @Test
    public void should_create() {
        SubscriptionAddress address = new SubscriptionAddress();
        address.setContactName("Jane Doe");
        address.setCity("Istanbul");
        address.setCountry("Turkey");
        address.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        address.setZipCode("34742");

        SubscriptionCustomer subscriptionCustomer = new SubscriptionCustomer();
        subscriptionCustomer.setName("John");
        subscriptionCustomer.setSurname("Doe");
        subscriptionCustomer.setEmail("test@mail.com");
        subscriptionCustomer.setIdentityNumber("111111");
        subscriptionCustomer.setGsmNumber("+905381111111");
        subscriptionCustomer.setBillingAddress(address);
        subscriptionCustomer.setShippingAddress(address);

        SubscriptionCardData paymentCard = new SubscriptionCardData();
        paymentCard.setCardHolderName("caner yesildag");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");

        InitializeSubscriptionRequest initializeSubscriptionRequest = new InitializeSubscriptionRequest();
        initializeSubscriptionRequest.setPaymentCard(paymentCard);
        initializeSubscriptionRequest.setPricingPlanReferenceCode("553d006c-da91-46d3-81a4-8297881d6b9e");
        initializeSubscriptionRequest.setCustomer(subscriptionCustomer);
        initializeSubscriptionRequest.setSubscriptionInitialStatus(SubscriptionInitialStatus.ACTIVE.name());
        initializeSubscriptionRequest.setConversationId("12345");
        initializeSubscriptionRequest.setLocale(Locale.TR.name());

        SubscriptionInitialize response = SubscriptionInitialize.create(initializeSubscriptionRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getCreatedSubscriptionData().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getCreatedDate());
        assertNotNull(response.getCreatedSubscriptionData().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getParentReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getStartDate());
        assertNotNull(response.getCreatedSubscriptionData().getTrialStartDate());
        assertNotNull(response.getCreatedSubscriptionData().getEndDate());
        assertNotNull(response.getCreatedSubscriptionData().getTrialEndDate());
        assertNotNull(response.getCreatedSubscriptionData().getTrialDays());
        assertEquals(response.getCreatedSubscriptionData().getPricingPlanReferenceCode(), "553d006c-da91-46d3-81a4-8297881d6b9e");
        assertEquals(response.getCreatedSubscriptionData().getSubscriptionStatus(), SubscriptionStatus.ACTIVE.name());
    }

    @Test
    public void should_create_with_existing_customer() {
        InitializeSubscriptionWithExistingCustomerRequest initializeSubscriptionWithExistingCustomerRequest = new InitializeSubscriptionWithExistingCustomerRequest();
        initializeSubscriptionWithExistingCustomerRequest.setCustomerReferenceCode("dfc1d5d2-1859-4582-9889-30f9c409d86f");
        initializeSubscriptionWithExistingCustomerRequest.setPricingPlanReferenceCode("553d006c-da91-46d3-81a4-8297881d6b9e");
        initializeSubscriptionWithExistingCustomerRequest.setSubscriptionInitialStatus(SubscriptionInitialStatus.PENDING.name());
        initializeSubscriptionWithExistingCustomerRequest.setConversationId("12345");
        initializeSubscriptionWithExistingCustomerRequest.setLocale(Locale.TR.name());

        SubscriptionInitialize response = SubscriptionInitialize.createWithExistingCustomer(initializeSubscriptionWithExistingCustomerRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getCreatedSubscriptionData().getCustomerReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getCreatedDate());
        assertEquals(response.getCreatedSubscriptionData().getCustomerReferenceCode(), "dfc1d5d2-1859-4582-9889-30f9c409d86f");
        assertNotNull(response.getCreatedSubscriptionData().getParentReferenceCode());
        assertNotNull(response.getCreatedSubscriptionData().getReferenceCode());
        assertEquals(response.getCreatedSubscriptionData().getPricingPlanReferenceCode(), "553d006c-da91-46d3-81a4-8297881d6b9e");
        assertEquals(response.getCreatedSubscriptionData().getSubscriptionStatus(), SubscriptionStatus.PENDING.name());
    }
}