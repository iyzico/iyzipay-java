package com.iyzipay.model.subscription;

import com.iyzipay.model.Status;
import com.iyzipay.request.subscription.CreateSubscriptionProductRequest;
import com.iyzipay.request.subscription.UpdateSubscriptionPricingPlanRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscriptionProductTest extends Sample {

    @Test
    public void should_create() {
        //given
        CreateSubscriptionProductRequest createSubscriptionProductRequest = new CreateSubscriptionProductRequest();
        createSubscriptionProductRequest.setName("customer-Caner-2");
        createSubscriptionProductRequest.setDescription("product");
        createSubscriptionProductRequest.setLocale("tr");
        createSubscriptionProductRequest.setConversationId("12345678");

        //when
        SubscriptionProduct response = SubscriptionProduct.create(createSubscriptionProductRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertEquals(response.getSubscriptionProductResource().getName(), createSubscriptionProductRequest.getName());
        assertEquals(response.getSubscriptionProductResource().getDescription(), "product");
    }
//
//    @Test
//    public void should_update() {
//        //given
//        UpdateSubscriptionPricingPlanRequest subscriptionPricingPlanRequest = new UpdateSubscriptionPricingPlanRequest();
//        subscriptionPricingPlanRequest.setName();
//
//        //when
//        SubscriptionProduct response = SubscriptionProduct.update("c777b5b0-bc79-4f3f-ac1f-71c064990939", subscriptionPricingPlanRequest, options);
//        //then
//
//    }

    @Test
    public void should_retrieve() {
        //when
        SubscriptionProduct response = SubscriptionProduct.retrieve("c777b5b0-bc79-4f3f-ac1f-71c064990939", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}