package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;
import com.iyzipay.request.RetrieveIyziupFormRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class IyziupFormSample extends Sample {

    @Test
    public void should_initialize_iyziup_form() {
        CreateIyziupFormInitializeRequest request = new CreateIyziupFormInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setShippingPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setMerchantOrderId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setTermsUrl("https://www.merchant.com/terms");
        request.setPreSalesContractUrl("https://www.merchant.com/preSalesContractUrl");
        request.setForceThreeDS(0);
        request.setPaymentSource("ZEN-OPENCART");
        request.setEnabledCardFamily("Bonus");

        List<Integer> enabledInstallments = new ArrayList<Integer>();
        enabledInstallments.add(2);
        enabledInstallments.add(3);
        enabledInstallments.add(6);
        enabledInstallments.add(9);
        request.setEnabledInstallments(enabledInstallments);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderItem firstOrderItem = new OrderItem();
        firstOrderItem.setId("BI101");
        firstOrderItem.setName("Binocular");
        firstOrderItem.setCategory1("Collectibles");
        firstOrderItem.setCategory2("Accessories");
        firstOrderItem.setItemUrl("www.merchant.biz/item1");
        firstOrderItem.setItemDescription("item1 description");
        firstOrderItem.setItemType(OrderItemType.PHYSICAL.name());
        firstOrderItem.setPrice(new BigDecimal("0.3"));
        orderItems.add(firstOrderItem);

        OrderItem secondOrderItem = new OrderItem();
        secondOrderItem.setId("BI102");
        secondOrderItem.setName("Game code");
        secondOrderItem.setCategory1("Game");
        secondOrderItem.setCategory2("Online Game Items");
        secondOrderItem.setItemUrl("www.merchant.biz/item2");
        secondOrderItem.setItemDescription("item2 description");
        secondOrderItem.setItemType(OrderItemType.VIRTUAL.name());
        secondOrderItem.setPrice(new BigDecimal("0.5"));
        orderItems.add(secondOrderItem);

        OrderItem thirdOrderItem = new OrderItem();
        thirdOrderItem.setId("BI103");
        thirdOrderItem.setName("Usb");
        thirdOrderItem.setCategory1("Electronics");
        thirdOrderItem.setCategory2("Usb / Cable");
        thirdOrderItem.setItemUrl("www.merchant.biz/item3");
        thirdOrderItem.setItemDescription("item3 description");
        thirdOrderItem.setItemType(OrderItemType.PHYSICAL.name());
        thirdOrderItem.setPrice(new BigDecimal("0.2"));
        orderItems.add(thirdOrderItem);
        request.setOrderItems(orderItems);

        IyziupFormInitialize iyziupFormInitialize = IyziupFormInitialize.create(request, options);

        System.out.println(iyziupFormInitialize);

        assertEquals(Status.SUCCESS.getValue(), iyziupFormInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), iyziupFormInitialize.getLocale());
        assertEquals("123456789", iyziupFormInitialize.getConversationId());
        assertNotEquals(0, iyziupFormInitialize.getSystemTime());
        assertNull(iyziupFormInitialize.getErrorCode());
        assertNull(iyziupFormInitialize.getErrorMessage());
        assertNull(iyziupFormInitialize.getErrorGroup());
        assertNotNull(iyziupFormInitialize.getContent());
    }

    @Test
    public void should_initialize_iyziup_form_with_initial_consumer_data() {
        CreateIyziupFormInitializeRequest request = new CreateIyziupFormInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.2"));
        request.setShippingPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setMerchantOrderId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setTermsUrl("https://www.merchant.com/terms");
        request.setPreSalesContractUrl("https://www.merchant.com/preSalesContractUrl");
        request.setForceThreeDS(0);
        request.setPaymentSource("ZEN-OPENCART");
        request.setEnabledCardFamily("Bonus");

        List<Integer> enabledInstallments = new ArrayList<Integer>();
        enabledInstallments.add(2);
        enabledInstallments.add(3);
        enabledInstallments.add(6);
        enabledInstallments.add(9);
        request.setEnabledInstallments(enabledInstallments);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderItem firstOrderItem = new OrderItem();
        firstOrderItem.setId("BI101");
        firstOrderItem.setName("Binocular");
        firstOrderItem.setCategory1("Collectibles");
        firstOrderItem.setCategory2("Accessories");
        firstOrderItem.setItemUrl("www.merchant.biz/item1");
        firstOrderItem.setItemDescription("item1 description");
        firstOrderItem.setItemType(OrderItemType.PHYSICAL.name());
        firstOrderItem.setPrice(new BigDecimal("0.3"));
        orderItems.add(firstOrderItem);

        OrderItem secondOrderItem = new OrderItem();
        secondOrderItem.setId("BI102");
        secondOrderItem.setName("Game code");
        secondOrderItem.setCategory1("Game");
        secondOrderItem.setCategory2("Online Game Items");
        secondOrderItem.setItemUrl("www.merchant.biz/item2");
        secondOrderItem.setItemDescription("item2 description");
        secondOrderItem.setItemType(OrderItemType.VIRTUAL.name());
        secondOrderItem.setPrice(new BigDecimal("0.5"));
        orderItems.add(secondOrderItem);

        OrderItem thirdOrderItem = new OrderItem();
        thirdOrderItem.setId("BI103");
        thirdOrderItem.setName("Usb");
        thirdOrderItem.setCategory1("Electronics");
        thirdOrderItem.setCategory2("Usb / Cable");
        thirdOrderItem.setItemUrl("www.merchant.biz/item3");
        thirdOrderItem.setItemDescription("item3 description");
        thirdOrderItem.setItemType(OrderItemType.PHYSICAL.name());
        thirdOrderItem.setPrice(new BigDecimal("0.2"));
        orderItems.add(thirdOrderItem);
        request.setOrderItems(orderItems);

        InitialConsumer initialConsumer = new InitialConsumer();
        initialConsumer.setName("ConsumerName");
        initialConsumer.setSurname("ConsumerSurname");
        initialConsumer.setEmail("consumermail@mail.com");
        initialConsumer.setGsmNumber("+905556667788");

        IyziupAddress homeAddress = new IyziupAddress();
        homeAddress.setAlias("Home Address");
        homeAddress.setContactName("ConsumerWithHomeAddress Name Surname");
        homeAddress.setAddressLine1("Home Address Line 1");
        homeAddress.setAddressLine2("Home Address Line 2");
        homeAddress.setCountry("HomeCountry");
        homeAddress.setCity("HomeCity");
        homeAddress.setZipCode("HomeZipCode");

        IyziupAddress workAddress = new IyziupAddress();
        workAddress.setAlias("Work Address");
        workAddress.setContactName("ConsumerWithWorkAddress Name Surname");
        workAddress.setAddressLine1("Work Address Line 1");
        workAddress.setAddressLine2("Work Address Line 2");
        workAddress.setCountry("WorkCountry");
        workAddress.setCity("WorkCity");
        workAddress.setZipCode("WorkZipCode");

        List<IyziupAddress> addressList = new ArrayList<IyziupAddress>();
        addressList.add(homeAddress);
        addressList.add(workAddress);
        initialConsumer.setAddressList(addressList);
        request.setInitialConsumer(initialConsumer);

        IyziupFormInitialize iyziupFormInitialize = IyziupFormInitialize.create(request, options);

        System.out.println(iyziupFormInitialize);

        assertEquals(Status.SUCCESS.getValue(), iyziupFormInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), iyziupFormInitialize.getLocale());
        assertEquals("123456789", iyziupFormInitialize.getConversationId());
        assertNotEquals(0, iyziupFormInitialize.getSystemTime());
        assertNull(iyziupFormInitialize.getErrorCode());
        assertNull(iyziupFormInitialize.getErrorMessage());
        assertNull(iyziupFormInitialize.getErrorGroup());
        assertNotNull(iyziupFormInitialize.getContent());
    }
}
