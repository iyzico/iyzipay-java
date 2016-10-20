package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreatePeccoInitializeRequest;
import com.iyzipay.request.CreatePeccoPaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PeccoSample extends Sample {

    @Test
    public void should_initialize_pecco() {
        CreatePeccoInitializeRequest request = new CreatePeccoInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("100000"));
        request.setPaidPrice(new BigDecimal("120000"));
        request.setCurrency(Currency.IRR.name());
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");

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
        firstBasketItem.setPrice(new BigDecimal("30000"));
        basketItems.add(firstBasketItem);

        BasketItem secondBasketItem = new BasketItem();
        secondBasketItem.setId("BI102");
        secondBasketItem.setName("Game code");
        secondBasketItem.setCategory1("Game");
        secondBasketItem.setCategory2("Online Game Items");
        secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
        secondBasketItem.setPrice(new BigDecimal("50000"));
        basketItems.add(secondBasketItem);

        BasketItem thirdBasketItem = new BasketItem();
        thirdBasketItem.setId("BI103");
        thirdBasketItem.setName("Usb");
        thirdBasketItem.setCategory1("Electronics");
        thirdBasketItem.setCategory2("Usb / Cable");
        thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        thirdBasketItem.setPrice(new BigDecimal("20000"));
        basketItems.add(thirdBasketItem);
        request.setBasketItems(basketItems);

        PeccoInitialize peccoInitialize = PeccoInitialize.create(request, options);

        System.out.println(peccoInitialize);

        assertEquals(Status.SUCCESS.getValue(), peccoInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), peccoInitialize.getLocale());
        assertEquals("123456789", peccoInitialize.getConversationId());
        assertNotNull(peccoInitialize.getSystemTime());
        assertNull(peccoInitialize.getErrorCode());
        assertNull(peccoInitialize.getErrorMessage());
        assertNull(peccoInitialize.getErrorGroup());
        assertNotNull(peccoInitialize.getHtmlContent());
    }

    @Test
    public void should_create_pecco_payment() {
        CreatePeccoPaymentRequest request = new CreatePeccoPaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("token");

        PeccoPayment peccoPayment = PeccoPayment.create(request, options);

        System.out.println(peccoPayment);

        assertEquals(Status.SUCCESS.getValue(), peccoPayment.getStatus());
        assertEquals(Locale.TR.getValue(), peccoPayment.getLocale());
        assertEquals("123456789", peccoPayment.getConversationId());
        assertNotNull(peccoPayment.getSystemTime());
        assertNull(peccoPayment.getErrorCode());
        assertNull(peccoPayment.getErrorMessage());
        assertNull(peccoPayment.getErrorGroup());
    }
}
