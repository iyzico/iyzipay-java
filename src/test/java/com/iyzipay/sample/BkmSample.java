package com.iyzipay.sample;

import com.iyzipay.model.Address;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.BasketItemType;
import com.iyzipay.model.Bkm;
import com.iyzipay.model.BkmInitialize;
import com.iyzipay.model.Buyer;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentGroup;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateBkmInitializeRequest;
import com.iyzipay.request.RetrieveBkmRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BkmSample extends Sample {

    @Test
    public void should_initialize_bkm() {
        CreateBkmInitializeRequest request = new CreateBkmInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");

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

        BkmInitialize bkmInitialize = BkmInitialize.create(request, options);

        System.out.println(bkmInitialize);

        assertEquals(Status.SUCCESS.getValue(), bkmInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), bkmInitialize.getLocale());
        assertEquals("123456789", bkmInitialize.getConversationId());
        assertNotEquals(0, bkmInitialize.getSystemTime());
        assertNull(bkmInitialize.getErrorCode());
        assertNull(bkmInitialize.getErrorMessage());
        assertNull(bkmInitialize.getErrorGroup());
        assertNotNull(bkmInitialize.getHtmlContent());
    }

    @Test
    public void should_retrieve_bkm_result() {
        RetrieveBkmRequest request = new RetrieveBkmRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("token");

        Bkm bkm = Bkm.retrieve(request, options);

        System.out.println(bkm);

        assertEquals(Status.SUCCESS.getValue(), bkm.getStatus());
        assertEquals(Locale.TR.getValue(), bkm.getLocale());
        assertEquals("123456789", bkm.getConversationId());
        assertNotEquals(0, bkm.getSystemTime());
        assertNull(bkm.getErrorCode());
        assertNull(bkm.getErrorMessage());
        assertNull(bkm.getErrorGroup());
    }
}
