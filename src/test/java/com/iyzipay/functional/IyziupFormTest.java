package com.iyzipay.functional;

import com.iyzipay.functional.builder.OrderItemBuilder;
import com.iyzipay.functional.builder.request.CreateIyziupFormInitializeRequestBuilder;
import com.iyzipay.functional.builder.request.RetrieveIyziupFormRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateIyziupFormInitializeRequest;
import com.iyzipay.request.RetrieveIyziupFormRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IyziupFormTest extends BaseTest {

    @Test
    public void should_initialize_iyziup_form_for_standard_merchant() {
        List<OrderItem> orderItems = Collections.singletonList(OrderItemBuilder.create().price(new BigDecimal("0.3")).build());
        CreateIyziupFormInitializeRequest request = CreateIyziupFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paidPrice(new BigDecimal("0.4"))
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
        assertNotNull(iyziupFormInitialize.getSystemTime());
        assertNotNull(iyziupFormInitialize.getToken());
        assertNotNull(iyziupFormInitialize.getContent());
    }

    @Test
    public void should_retrieve_checkout_form_result() {
        List<OrderItem> orderItems = Collections.singletonList(OrderItemBuilder.create().price(new BigDecimal("0.3")).build());
        CreateIyziupFormInitializeRequest request = CreateIyziupFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paidPrice(new BigDecimal("0.4"))
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
        assertNotNull(iyziupForm.getSystemTime());
    }
}
