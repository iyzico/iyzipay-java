package com.iyzipay.sample.subscription;

import com.iyzipay.IyzipayResource;
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
        CreateSubscriptionProductRequest createSubscriptionProductRequest = new CreateSubscriptionProductRequest();
        createSubscriptionProductRequest.setName("customer-Caner-3");
        createSubscriptionProductRequest.setDescription("product");
        createSubscriptionProductRequest.setLocale(Locale.TR.name());
        createSubscriptionProductRequest.setConversationId("12345678");

        SubscriptionProduct response = SubscriptionProduct.create(createSubscriptionProductRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertEquals(response.getSubscriptionProductData().getDescription(), "product");
        assertNotNull(response.getSubscriptionProductData().getReferenceCode());
        assertNotNull(response.getSubscriptionProductData().getPricingPlanList());
        assertNotNull(response.getSubscriptionProductData().getCreatedDate());
        assertNotNull(response.getSubscriptionProductData().getName());
    }

    @Test
    public void should_update() {
        SubscriptionUpdateProductRequest updateProductRequest = new SubscriptionUpdateProductRequest();
        updateProductRequest.setName("Caner-Product");
        updateProductRequest.setDescription("product");
        updateProductRequest.setLocale(Locale.TR.name());
        updateProductRequest.setConversationId("12346543");

        SubscriptionProduct response = SubscriptionProduct.update("c777b5b0-bc79-4f3f-ac1f-71c064990939", updateProductRequest, options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
        assertNotNull(response.getSubscriptionProductData().getName());
        assertNotNull(response.getSubscriptionProductData().getDescription());
        assertNotNull(response.getSubscriptionProductData().getCreatedDate());
        assertNotNull(response.getSubscriptionProductData().getPricingPlanList());
        assertNotNull(response.getSubscriptionProductData().getReferenceCode());
    }

    @Test
    public void should_retrieve() {
        SubscriptionProduct response = SubscriptionProduct.retrieve("c777b5b0-bc79-4f3f-ac1f-71c064990939", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }

    @Test
    public void should_delete() {
        IyzipayResource response = SubscriptionProduct.delete("5389bdf2-9ddd-4555-a199-c93f82efec84", options);

        assertEquals(response.getStatus(), Status.SUCCESS.getValue());
    }
}