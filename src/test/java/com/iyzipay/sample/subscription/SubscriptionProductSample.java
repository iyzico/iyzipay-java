package com.iyzipay.sample.subscription;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.SubscriptionProduct;
import com.iyzipay.request.subscription.CreateSubscriptionProductRequest;
import com.iyzipay.request.subscription.SubscriptionUpdateProductRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionProductSample extends Sample {

    @Test
    public void should_create() {
        //given
        CreateSubscriptionProductRequest createSubscriptionProductRequest = new CreateSubscriptionProductRequest();
        createSubscriptionProductRequest.setName("customer-Caner-3");
        createSubscriptionProductRequest.setDescription("product");
        createSubscriptionProductRequest.setLocale(Locale.TR.name());
        createSubscriptionProductRequest.setConversationId("12345678");

        //when
        SubscriptionProduct response = SubscriptionProduct.create(createSubscriptionProductRequest, options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertEquals(response.getSubscriptionProductResource().getDescription(), "product");
        assertNotNull(response.getSubscriptionProductResource().getReferenceCode());
        assertNotNull(response.getSubscriptionProductResource().getPricingPlanList());
        assertNotNull(response.getSubscriptionProductResource().getCreatedDate());
        assertNotNull(response.getSubscriptionProductResource().getName());
    }

    @Test
    public void should_update() {
        //given
        SubscriptionUpdateProductRequest updateProductRequest = new SubscriptionUpdateProductRequest();
        updateProductRequest.setName("Caner-Product");
        updateProductRequest.setDescription("product");
        updateProductRequest.setLocale(Locale.TR.name());
        updateProductRequest.setConversationId("12346543");

        //when
        SubscriptionProduct response = SubscriptionProduct.update("c777b5b0-bc79-4f3f-ac1f-71c064990939", updateProductRequest, options);
        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionProductResource().getName());
        assertNotNull(response.getSubscriptionProductResource().getDescription());
        assertNotNull(response.getSubscriptionProductResource().getCreatedDate());
        assertNotNull(response.getSubscriptionProductResource().getPricingPlanList());
        assertNotNull(response.getSubscriptionProductResource().getReferenceCode());
    }

    @Test
    public void should_retrieve() {
        //when
        SubscriptionProduct response = SubscriptionProduct.retrieve("c777b5b0-bc79-4f3f-ac1f-71c064990939", options);

        //then
        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}