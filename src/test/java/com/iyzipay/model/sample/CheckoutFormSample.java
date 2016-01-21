package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;
import com.iyzipay.request.RetrieveCheckoutFormAuthRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckoutFormSample extends Sample {

    @Test
    public void should_initialize_checkout_form() {
        CreateCheckoutFormInitializeRequest request = new CreateCheckoutFormInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1.0"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setBuyer(newBuyer());
        request.setShippingAddress(newShippingAddress());
        request.setBillingAddress(newBillingAddress());
        request.setBasketItems(newBasketItems());
        request.setCallbackUrl("https://www.merchant.com/callback");

        CheckoutFormInitialize checkoutFormInitialize = CheckoutFormInitialize.create(request, options);

        System.out.println(checkoutFormInitialize);

        assertNotNull(checkoutFormInitialize.getConversationId());
        assertNotNull(checkoutFormInitialize.getLocale());
        assertEquals(Locale.TR.getValue(), request.getLocale());
    }

    @Test
    public void should_retrieve_checkout_form_auth() {
        RetrieveCheckoutFormAuthRequest request = new RetrieveCheckoutFormAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("token");

        CheckoutFormAuth checkoutFormAuth = CheckoutFormAuth.retrieve(request, options);

        System.out.println(checkoutFormAuth);

        assertNotNull(checkoutFormAuth.getConversationId());
        assertNotNull(checkoutFormAuth.getLocale());
        assertEquals(Locale.TR.getValue(), checkoutFormAuth.getLocale());
    }

    private Buyer newBuyer() {
        Buyer buyer = new Buyer();
        buyer.setId("BY789");
        buyer.setName("Sabri Onur");
        buyer.setSurname("Tüzün");
        buyer.setGsmNumber("+905350000000");
        buyer.setEmail("email@email.com");
        buyer.setIdentityNumber("74300864791");
        buyer.setLastLoginDate("2015-10-05 12:43:35");
        buyer.setRegistrationDate("2013-04-21 15:12:09");
        buyer.setRegistrationAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy");
        buyer.setIp("85.34.78.112");
        buyer.setCity("Istanbul");
        buyer.setCountry("Turkiye");
        buyer.setZipCode("34732");
        return buyer;
    }

    private Address newShippingAddress() {
        Address shippingAddress = new Address();
        shippingAddress.setContactName("Hakan Erdoğan");
        shippingAddress.setCity("Istanbul");
        shippingAddress.setCountry("Turkiye");
        shippingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        shippingAddress.setZipCode("34742");
        return shippingAddress;
    }

    private Address newBillingAddress() {
        Address billingAddress = new Address();
        billingAddress.setContactName("Hakan Erdoğan");
        billingAddress.setCity("İstanbul");
        billingAddress.setCountry("Türkiye");
        billingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        billingAddress.setZipCode("34742");
        return billingAddress;
    }

    private List<BasketItem> newBasketItems() {
        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        BasketItem basketItem1 = new BasketItem();
        basketItem1.setId("BI101");
        basketItem1.setName("ABC Marka Kolye");
        basketItem1.setCategory1("Giyim");
        basketItem1.setCategory2("Aksesuar");
        basketItem1.setItemType(BasketItemType.PHYSICAL.name());
        basketItem1.setPrice(new BigDecimal("0.3"));
        basketItem1.setSubMerchantKey("ha3us4v5mk2652kkjk5728cc4407an");
        basketItem1.setSubMerchantPrice(new BigDecimal("0.27"));
        basketItems.add(basketItem1);

        BasketItem basketItem2 = new BasketItem();
        basketItem2.setId("BI102");
        basketItem2.setName("XYZ Oyun Kodu");
        basketItem2.setCategory1("Oyun");
        basketItem2.setCategory2("Online Oyun Kodları");
        basketItem2.setItemType(BasketItemType.VIRTUAL.name());
        basketItem2.setPrice(new BigDecimal("0.5"));
        basketItem2.setSubMerchantKey("ha3us4v5mk2652kkjk5728cc4407an");
        basketItem2.setSubMerchantPrice(new BigDecimal("0.42"));
        basketItems.add(basketItem2);

        BasketItem basketItem3 = new BasketItem();
        basketItem3.setId("BI103");
        basketItem3.setName("EDC Marka Usb");
        basketItem3.setCategory1("Elektronik");
        basketItem3.setCategory2("Usb / Cable");
        basketItem3.setItemType(BasketItemType.PHYSICAL.name());
        basketItem3.setPrice(new BigDecimal("0.2"));
        basketItem3.setSubMerchantKey("ha3us4v5mk2652kkjk5728cc4407an");
        basketItem3.setSubMerchantPrice(new BigDecimal("0.18"));
        basketItems.add(basketItem3);
        return basketItems;
    }
}
