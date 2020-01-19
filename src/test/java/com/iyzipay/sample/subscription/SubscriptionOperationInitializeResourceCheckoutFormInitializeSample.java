package com.iyzipay.sample.subscription;

import com.iyzipay.model.Address;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.subscription.resource.SubscriptionCustomerResource;
import com.iyzipay.model.subscription.SubscriptionCheckoutFormInitialize;
import com.iyzipay.request.subscription.InitializeSubscriptionCheckoutFormRequest;
import com.iyzipay.sample.Sample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionOperationInitializeResourceCheckoutFormInitializeSample extends Sample {

//    @Test
//    public void should_init_subscription_checkoutForm() {
//        InitializeSubscriptionCheckoutFormRequest request = new InitializeSubscriptionCheckoutFormRequest();
//        request.setPricingPlanReferenceCode("b6d4bdae-c483-4959-9edd-f37232122d91");
//        request.setSubscriptionInitialStatus("PENDING");
//        request.setCallbackUrl("callbackUrl");
//
//        Address address = new Address();
//        address.setAddress("Address");
//        address.setCity("City");
//        address.setCountry("Country");
//        address.setContactName("ContactName");
//        address.setZipCode("ZipCode");
//        address.setDistrict("District");
//
//        SubscriptionCustomerResource subscriptionCustomerResource = new SubscriptionCustomerResource();
//        subscriptionCustomerResource.setName("John");
//        subscriptionCustomerResource.setSurname("Doe");
//        subscriptionCustomerResource.setEmail("test@mail.com");
//        subscriptionCustomerResource.setIdentityNumber("11111111111");
//        subscriptionCustomerResource.setGsmNumber("+905350000000");
//        subscriptionCustomerResource.setBillingAddress(address);
//        subscriptionCustomerResource.setShippingAddress(address);
//        request.setSubscriptionCustomerResource(subscriptionCustomerResource);
//
//        SubscriptionCheckoutFormInitialize response = SubscriptionCheckoutFormInitialize.initialize(request, options);
//
//        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
//        assertEquals(Locale.TR.getValue(), response.getLocale());
//        assertNotNull(response.getToken());
//        assertNotNull(response.getCheckoutFormContent());
//        assertNotNull(response.getTokenExpireTime());
//    }
}
