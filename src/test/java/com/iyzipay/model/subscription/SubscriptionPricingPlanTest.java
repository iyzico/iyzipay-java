package com.iyzipay.model.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.request.subscription.CreateSubscriptionPricingPlanRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionPricingPlanRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionPricingPlanTest extends Sample {

    @Test
    public void should_create() {
        //given
        CreateSubscriptionPricingPlanRequest createSubscriptionPricingPlanRequest = new CreateSubscriptionPricingPlanRequest();
        createSubscriptionPricingPlanRequest.setPlanPaymentType("RECURRING");
        createSubscriptionPricingPlanRequest.setName("caner-pricing-plan");
        createSubscriptionPricingPlanRequest.setPrice(BigDecimal.TEN);
        createSubscriptionPricingPlanRequest.setCurrencyCode("TRY");
        createSubscriptionPricingPlanRequest.setPaymentInterval("WEEKLY");
        createSubscriptionPricingPlanRequest.setPaymentIntervalCount(1);
        createSubscriptionPricingPlanRequest.setTrialPeriodDays(10);
        createSubscriptionPricingPlanRequest.setRecurrenceCount(9);
        createSubscriptionPricingPlanRequest.setLocale("TR");
        createSubscriptionPricingPlanRequest.setConversationId("12345678");

        //when
        SubscriptionPricingPlan response = SubscriptionPricingPlan.create("c777b5b0-bc79-4f3f-ac1f-71c064990939", createSubscriptionPricingPlanRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPlanPaymentType());
        assertNotNull(response.getSubscriptionPricingPlanResource().getName());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPrice());
        assertNotNull(response.getSubscriptionPricingPlanResource().getCurrencyCode());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPaymentInterval());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPaymentIntervalCount());
        assertNotNull(response.getSubscriptionPricingPlanResource().getTrialPeriodDays());
        assertNotNull(response.getSubscriptionPricingPlanResource().getRecurrenceCount());
        assertNotNull(response.getSubscriptionPricingPlanResource().getReferenceCode());
        assertNotNull(response.getSubscriptionPricingPlanResource().getProductReferenceCode());
        assertNotNull(response.getSubscriptionPricingPlanResource().getCreatedDate());
    }

    @Test
    public void should_update() {
        //given
        UpdateSubscriptionPricingPlanRequest updateSubscriptionPricingPlanRequest = new UpdateSubscriptionPricingPlanRequest();
        updateSubscriptionPricingPlanRequest.setName("caner-pricing-plan");
        updateSubscriptionPricingPlanRequest.setTrialPeriodDays(13);
        updateSubscriptionPricingPlanRequest.setLocale("TR");
        updateSubscriptionPricingPlanRequest.setConversationId("12345678");

        //when
        SubscriptionPricingPlan response = SubscriptionPricingPlan.update("553d006c-da91-46d3-81a4-8297881d6b9e", updateSubscriptionPricingPlanRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertEquals(response.getSubscriptionPricingPlanResource().getTrialPeriodDays(), updateSubscriptionPricingPlanRequest.getTrialPeriodDays());
        assertNotNull(response.getSubscriptionPricingPlanResource().getCreatedDate());
        assertNotNull(response.getSubscriptionPricingPlanResource().getCurrencyCode());
        assertNotNull(response.getSubscriptionPricingPlanResource().getName());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPaymentInterval());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPaymentIntervalCount());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPlanPaymentType());
        assertNotNull(response.getSubscriptionPricingPlanResource().getPrice());
        assertNotNull(response.getSubscriptionPricingPlanResource().getProductReferenceCode());
        assertNotNull(response.getSubscriptionPricingPlanResource().getRecurrenceCount());
    }

    @Test
    public void should_retrieve() {
        //when
        SubscriptionPricingPlan response = SubscriptionPricingPlan.retrieve("553d006c-da91-46d3-81a4-8297881d6b9e", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}