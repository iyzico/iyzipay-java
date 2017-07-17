package com.iyzipay.functional;

import com.iyzipay.functional.builder.BasketItemBuilder;
import com.iyzipay.functional.builder.request.CreateCheckoutFormInitializeRequestBuilder;
import com.iyzipay.functional.builder.request.RetrieveCheckoutFormRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;
import com.iyzipay.request.RetrieveCheckoutFormRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckoutFormTest extends BaseTest {

    @Test
    public void should_initialize_checkout_form_for_standard_merchant() {
        List<BasketItem> basketItems = Collections.singletonList(BasketItemBuilder.create().price(new BigDecimal("0.3")).build());
        CreateCheckoutFormInitializeRequest request = CreateCheckoutFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paymentGroup(PaymentGroup.LISTING.name())
                .paidPrice(new BigDecimal("0.4"))
                .callbackUrl("https://www.merchant.com/callback")
                .basketItems(basketItems)
                .build();

        CheckoutFormInitialize checkoutFormInitialize = CheckoutFormInitialize.create(request, options);

        System.out.println(checkoutFormInitialize);

        assertEquals(Status.SUCCESS.getValue(), checkoutFormInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), checkoutFormInitialize.getLocale());
        assertNotNull(checkoutFormInitialize.getSystemTime());
        assertNotNull(checkoutFormInitialize.getToken());
        assertNotNull(checkoutFormInitialize.getCheckoutFormContent());
    }

    @Test
    public void should_retrieve_checkout_form_result() {
        List<BasketItem> basketItems = Collections.singletonList(BasketItemBuilder.create().price(new BigDecimal("0.3")).build());
        CreateCheckoutFormInitializeRequest request = CreateCheckoutFormInitializeRequestBuilder.create()
                .price(new BigDecimal("0.3"))
                .paymentGroup(PaymentGroup.LISTING.name())
                .paidPrice(new BigDecimal("0.4"))
                .callbackUrl("https://www.merchant.com/callback")
                .basketItems(basketItems)
                .build();

        CheckoutFormInitialize checkoutFormInitialize = CheckoutFormInitialize.create(request, options);

        RetrieveCheckoutFormRequest retrieveCheckoutFormRequest = RetrieveCheckoutFormRequestBuilder.create()
                .token(checkoutFormInitialize.getToken())
                .build();

        CheckoutForm checkoutForm = CheckoutForm.retrieve(retrieveCheckoutFormRequest, options);

        System.out.println(checkoutForm);

        assertNotNull(checkoutForm.getErrorMessage());
        assertEquals(Status.FAILURE.getValue(), checkoutForm.getStatus());
        assertNotNull(checkoutForm.getSystemTime());
    }
}
