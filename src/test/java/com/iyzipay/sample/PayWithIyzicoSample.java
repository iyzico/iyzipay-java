package com.iyzipay.sample;

import com.iyzipay.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PayWithIyzicoSample extends Sample {

    @Test
    public void should_initialize_pay_with_iyzico() {
        PayWithIyzicoInitializeRequest request = new PayWithIyzicoInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setCurrency(Currency.TRY.name());
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setPosOrderId("1");
        request.setEnabledCardFamily("bonus");
        request.setCancelUrl("https://www.merchant.com/cancel");
        request.setNotificationUrl("https://www.merchant.com/notify");

        List<Integer> enabledInstallments = new ArrayList<Integer>();
        enabledInstallments.add(2);
        enabledInstallments.add(3);
        enabledInstallments.add(6);
        enabledInstallments.add(9);
        request.setEnabledInstallments(enabledInstallments);

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

        PayWithIyzicoInitialize payWithIyzicoInitialize = PayWithIyzicoInitialize.create(request, options);

        System.out.println(payWithIyzicoInitialize);

        assertEquals(Status.SUCCESS.getValue(), payWithIyzicoInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), payWithIyzicoInitialize.getLocale());
        assertEquals("123456789", payWithIyzicoInitialize.getConversationId());
        assertNotEquals(0, payWithIyzicoInitialize.getSystemTime());
        assertNull(payWithIyzicoInitialize.getErrorCode());
        assertNull(payWithIyzicoInitialize.getErrorMessage());
        assertNull(payWithIyzicoInitialize.getErrorGroup());
        assertNotNull(payWithIyzicoInitialize.getToken());
        assertNotNull(payWithIyzicoInitialize.getTokenExpireTime());
        assertNotNull(payWithIyzicoInitialize.getPayWithIyzicoPageUrl());
    }

    @Test
    public void should_initialize_pay_with_iyzico_marketplace() {
        PayWithIyzicoInitializeRequest request = new PayWithIyzicoInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setCurrency(Currency.TRY.name());
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setPosOrderId("1");
        request.setEnabledCardFamily("bonus");
        request.setCancelUrl("https://www.merchant.com/cancel");
        request.setNotificationUrl("https://www.merchant.com/notify");

        List<Integer> enabledInstallments = new ArrayList<Integer>();
        enabledInstallments.add(2);
        enabledInstallments.add(3);
        enabledInstallments.add(6);
        enabledInstallments.add(9);
        request.setEnabledInstallments(enabledInstallments);

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
        String subMerchantKey1 = System.getProperty("subMerchantKey1");
        BasketItem firstBasketItem = new BasketItem();
        firstBasketItem.setId("BI101");
        firstBasketItem.setName("Binocular");
        firstBasketItem.setCategory1("Collectibles");
        firstBasketItem.setCategory2("Accessories");
        firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        firstBasketItem.setPrice(new BigDecimal("0.3"));
        firstBasketItem.setSubMerchantPrice(new BigDecimal("0.3"));
        firstBasketItem.setSubMerchantKey(subMerchantKey1);
        basketItems.add(firstBasketItem);

        String subMerchantKey2 = System.getProperty("subMerchantKey2");
        BasketItem secondBasketItem = new BasketItem();
        secondBasketItem.setId("BI102");
        secondBasketItem.setName("Game code");
        secondBasketItem.setCategory1("Game");
        secondBasketItem.setCategory2("Online Game Items");
        secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
        secondBasketItem.setPrice(new BigDecimal("0.5"));
        secondBasketItem.setSubMerchantPrice(new BigDecimal("0.5"));
        secondBasketItem.setSubMerchantKey(subMerchantKey2);
        basketItems.add(secondBasketItem);

        String subMerchantKey3 = System.getProperty("subMerchantKey3");
        BasketItem thirdBasketItem = new BasketItem();
        thirdBasketItem.setId("BI103");
        thirdBasketItem.setName("Usb");
        thirdBasketItem.setCategory1("Electronics");
        thirdBasketItem.setCategory2("Usb / Cable");
        thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        thirdBasketItem.setPrice(new BigDecimal("0.2"));
        thirdBasketItem.setSubMerchantPrice(new BigDecimal("0.2"));
        thirdBasketItem.setSubMerchantKey(subMerchantKey3);
        basketItems.add(thirdBasketItem);
        request.setBasketItems(basketItems);

        PayWithIyzicoInitialize payWithIyzicoInitialize = PayWithIyzicoInitialize.create(request, options);

        System.out.println(payWithIyzicoInitialize);

        assertEquals(Status.SUCCESS.getValue(), payWithIyzicoInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), payWithIyzicoInitialize.getLocale());
        assertEquals("123456789", payWithIyzicoInitialize.getConversationId());
        assertNotEquals(0, payWithIyzicoInitialize.getSystemTime());
        assertNull(payWithIyzicoInitialize.getErrorCode());
        assertNull(payWithIyzicoInitialize.getErrorMessage());
        assertNull(payWithIyzicoInitialize.getErrorGroup());
        assertNotNull(payWithIyzicoInitialize.getToken());
        assertNotNull(payWithIyzicoInitialize.getTokenExpireTime());
        assertNotNull(payWithIyzicoInitialize.getPayWithIyzicoPageUrl());
    }

}
