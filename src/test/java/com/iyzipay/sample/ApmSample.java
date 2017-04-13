package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateApmInitializeRequest;
import com.iyzipay.request.RetrieveApmRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ApmSample extends Sample {

    @Test
    public void should_initialize_apm_payment() {
        CreateApmInitializeRequest request = new CreateApmInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setCurrency(Currency.EUR.name());
        request.setCountryCode("DE");
        request.setPaymentChannel(PaymentChannel.WEB.name());
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setAccountHolderName("John Doe");
        request.setMerchantCallbackUrl("https://www.merchant.com/callback");
        request.setMerchantErrorUrl("https://www.merchant.com/error");
        request.setMerchantNotificationUrl("https://www.merchant.com/notification");
        request.setApmType(ApmType.SOFORT.name());

        Buyer buyer = new Buyer();
        buyer.setId("BY789");
        buyer.setName("John");
        buyer.setSurname("Doe");
        buyer.setGsmNumber("+905350000000");
        buyer.setEmail("email@email.com");
        buyer.setIdentityNumber("74300864791");
        buyer.setLastLoginDate("2015-10-05 12:43:35");
        buyer.setRegistrationDate("2013-04-21 15:12:09");
        buyer.setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        buyer.setIp("85.34.78.112");
        buyer.setCity("Istanbul");
        buyer.setCountry("Turkey");
        buyer.setZipCode("34732");
        request.setBuyer(buyer);

        Address shippingAddress = new Address();
        shippingAddress.setContactName("Jane Doe");
        shippingAddress.setCity("Istanbul");
        shippingAddress.setCountry("Turkey");
        shippingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        shippingAddress.setZipCode("34742");
        request.setShippingAddress(shippingAddress);

        Address billingAddress = new Address();
        billingAddress.setContactName("Jane Doe");
        billingAddress.setCity("Istanbul");
        billingAddress.setCountry("Turkey");
        billingAddress.setAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");
        billingAddress.setZipCode("34742");
        request.setBillingAddress(billingAddress);

        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        BasketItem firstBasketItem = new BasketItem();
        firstBasketItem.setId("BI101");
        firstBasketItem.setName("Binocular");
        firstBasketItem.setCategory1("Collectibles");
        firstBasketItem.setCategory2("Accessories");
        firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        firstBasketItem.setPrice(new BigDecimal("0.3"));
        basketItems.add(firstBasketItem);

        BasketItem secondBasketItem = new BasketItem();
        secondBasketItem.setId("BI102");
        secondBasketItem.setName("Game code");
        secondBasketItem.setCategory1("Game");
        secondBasketItem.setCategory2("Online Game Items");
        secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
        secondBasketItem.setPrice(new BigDecimal("0.5"));
        basketItems.add(secondBasketItem);

        BasketItem thirdBasketItem = new BasketItem();
        thirdBasketItem.setId("BI103");
        thirdBasketItem.setName("Usb");
        thirdBasketItem.setCategory1("Electronics");
        thirdBasketItem.setCategory2("Usb / Cable");
        thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        thirdBasketItem.setPrice(new BigDecimal("0.2"));
        basketItems.add(thirdBasketItem);
        request.setBasketItems(basketItems);

        Apm apmInitialize = Apm.create(request, options);

        System.out.println(apmInitialize);

        assertEquals(Status.SUCCESS.getValue(), apmInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), apmInitialize.getLocale());
        assertEquals("123456789", apmInitialize.getConversationId());
        assertNotNull(apmInitialize.getRedirectUrl());
        assertNull(apmInitialize.getErrorCode());
        assertNull(apmInitialize.getErrorMessage());
        assertNull(apmInitialize.getErrorGroup());
    }

    @Test
    public void should_retrieve_apm_result() {
        RetrieveApmRequest retrieveApmRequest = new RetrieveApmRequest();
        retrieveApmRequest.setLocale(Locale.TR.getValue());
        retrieveApmRequest.setConversationId("123456789");
        retrieveApmRequest.setPaymentId("1");

        Apm retrieve = Apm.retrieve(retrieveApmRequest, options);

        System.out.println(retrieve);

        assertEquals(Status.SUCCESS.getValue(), retrieve.getStatus());
        assertEquals(Locale.TR.getValue(), retrieve.getLocale());
        assertEquals("123456789", retrieve.getConversationId());
    }
}
