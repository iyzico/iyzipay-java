package com.iyzipay.functional;

import com.iyzipay.functional.builder.BasketItemBuilder;
import com.iyzipay.functional.builder.request.CreateCheckoutFormInitializeRequestBuilder;
import com.iyzipay.functional.builder.request.RetrieveCheckoutFormRequestBuilder;
import com.iyzipay.model.BasketItem;
import com.iyzipay.model.CheckoutForm;
import com.iyzipay.model.CheckoutFormInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentGroup;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;
import com.iyzipay.request.RetrieveCheckoutFormRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
        assertNotEquals(0, checkoutFormInitialize.getSystemTime());
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
        assertNotEquals(0, checkoutForm.getSystemTime());
    }
}
