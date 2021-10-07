package com.iyzipay.functional;

import com.iyzipay.functional.builder.OrderItemBuilder;
import com.iyzipay.functional.builder.request.CreateIyziupFormInitializeRequestBuilder;
import com.iyzipay.functional.builder.request.RetrieveIyziupFormRequestBuilder;
import com.iyzipay.model.InitialConsumer;
import com.iyzipay.model.IyziupAddress;
import com.iyzipay.model.IyziupForm;
import com.iyzipay.model.IyziupFormInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.OrderItem;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;
import com.iyzipay.request.RetrieveIyziupFormRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class IyziupFormTest extends IyziupBaseTest {

    @Test
    public void should_initialize_iyziup_form_for_standard_merchant() {
        List<OrderItem> orderItems = Collections.singletonList(OrderItemBuilder.create().price(new BigDecimal("0.3")).itemDecription("item description").build());
        CreateIyziupFormInitializeRequest request = CreateIyziupFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paidPrice(new BigDecimal("0.4"))
                .shippingPrice(new BigDecimal("0.1"))
                .callbackUrl("https://www.merchant.com/callback")
                .termsUrl("https://www.merchant.com/termsUrl")
                .preSalesContractUrl("https://www.merchant.com/preSalesContractUrl")
                .forceThreeDS(0)
                .orderItems(orderItems)
                .build();

        IyziupFormInitialize iyziupFormInitialize = IyziupFormInitialize.create(request, options);

        System.out.println(iyziupFormInitialize);

        assertEquals(Status.SUCCESS.getValue(), iyziupFormInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), iyziupFormInitialize.getLocale());
        assertNotEquals(0, iyziupFormInitialize.getSystemTime());
        assertNotNull(iyziupFormInitialize.getToken());
        assertNotNull(iyziupFormInitialize.getContent());
    }

    @Test
    public void should_initialize_iyziup_form_for_standard_merchant_with_initial_consumer_data() {
        List<OrderItem> orderItems = Collections.singletonList(OrderItemBuilder.create().price(new BigDecimal("0.3")).itemDecription("item description").build());
        CreateIyziupFormInitializeRequest request = CreateIyziupFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paidPrice(new BigDecimal("0.4"))
                .shippingPrice(new BigDecimal("0.1"))
                .callbackUrl("https://www.merchant.com/callback")
                .termsUrl("https://www.merchant.com/termsUrl")
                .preSalesContractUrl("https://www.merchant.com/preSalesContractUrl")
                .forceThreeDS(0)
                .orderItems(orderItems)
                .initialConsumer(createDummyInitialConsumerData())
                .build();

        IyziupFormInitialize iyziupFormInitialize = IyziupFormInitialize.create(request, options);

        System.out.println(iyziupFormInitialize);

        assertEquals(Status.SUCCESS.getValue(), iyziupFormInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), iyziupFormInitialize.getLocale());
        assertNotEquals(0, iyziupFormInitialize.getSystemTime());
        assertNotNull(iyziupFormInitialize.getToken());
        assertNotNull(iyziupFormInitialize.getContent());
    }

    @Test
    public void should_retrieve_checkout_form_result() {
        List<OrderItem> orderItems = Collections.singletonList(OrderItemBuilder.create().price(new BigDecimal("0.3")).itemDecription("item description").build());
        CreateIyziupFormInitializeRequest request = CreateIyziupFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paidPrice(new BigDecimal("0.4"))
                .shippingPrice(new BigDecimal("0.1"))
                .callbackUrl("https://www.merchant.com/callback")
                .termsUrl("https://www.merchant.com/termsUrl")
                .preSalesContractUrl("https://www.merchant.com/preSalesContractUrl")
                .forceThreeDS(0)
                .orderItems(orderItems)
                .build();

        IyziupFormInitialize iyziupFormInitialize = IyziupFormInitialize.create(request, options);

        RetrieveIyziupFormRequest retrieveIyziupFormRequest = RetrieveIyziupFormRequestBuilder.create()
                .token(iyziupFormInitialize.getToken())
                .build();

        IyziupForm iyziupForm = IyziupForm.retrieve(retrieveIyziupFormRequest, options);

        System.out.println(iyziupForm);

        assertNotNull(iyziupForm.getErrorMessage());
        assertEquals(Status.FAILURE.getValue(), iyziupForm.getStatus());
        assertNotEquals(0, iyziupFormInitialize.getSystemTime());
    }

    private InitialConsumer createDummyInitialConsumerData() {
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
        return initialConsumer;
    }
}
