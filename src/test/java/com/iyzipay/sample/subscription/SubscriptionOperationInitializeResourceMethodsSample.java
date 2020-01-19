package com.iyzipay.sample.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.*;
import com.iyzipay.model.subscription.resource.SubscriptionCardResource;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.request.subscription.InitializeSubscriptionRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionOperationInitializeResourceMethodsSample extends Sample {

    @Test
    public void should_initialize_subscription() {
        InitializeSubscriptionRequest request = new InitializeSubscriptionRequest();
        request.setPricingPlanReferenceCode("Token");
        request.setSubscriptionInitialStatus("Status");

        SubscriptionCardResource card = new SubscriptionCardResource();
        card.setCardHolderName("John Doe");
        card.setCardNumber("5528790000000008");
        card.setExpireMonth("12");
        card.setExpireYear("2030");
        card.setCvc("123");
        request.setPaymentCard(card);

        Address address = new Address();
        address.setAddress("Address");
        address.setCity("City");
        address.setCountry("Country");
        address.setContactName("ContactName");
        address.setZipCode("ZipCode");
        address.setDistrict("District");

        SubscriptionCustomerResource subscriptionCustomerResource = new SubscriptionCustomerResource();
        subscriptionCustomerResource.setName("John");
        subscriptionCustomerResource.setSurname("Doe");
        subscriptionCustomerResource.setEmail("test@mail.com");
        subscriptionCustomerResource.setIdentityNumber("11111111111");
        subscriptionCustomerResource.setGsmNumber("+905350000000");
        subscriptionCustomerResource.setBillingAddress(address);
        subscriptionCustomerResource.setShippingAddress(address);
        request.setSubscriptionCustomerResource(subscriptionCustomerResource);


        SubscriptionInitialize response = SubscriptionInitialize.create(request, options);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertNotNull(response.getCreatedSubscriptionResource());
    }
}
