package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreatePeccoInitializeRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePeccoPaymentRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreatePeccoInitializeRequest;
import com.iyzipay.request.CreatePeccoPaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PeccoTest extends BaseTest {

    @Test
    public void should_initialize_pecco() {
        CreatePeccoInitializeRequest request = CreatePeccoInitializeRequestBuilder.create()
                .callbackUrl("https://www.merchant.com/callback")
                .paymentGroup(PaymentGroup.LISTING.name())
                .price(new BigDecimal("1"))
                .paidPrice(new BigDecimal("10"))
                .build();

        PeccoInitialize peccoInitialize = PeccoInitialize.create(request, options);

        System.out.println(peccoInitialize);

        assertEquals(Locale.TR.getValue(), peccoInitialize.getLocale());
        assertEquals(Status.SUCCESS.getValue(), peccoInitialize.getStatus());
        assertNotNull(peccoInitialize.getSystemTime());
        assertNotNull(peccoInitialize.getHtmlContent());
        assertNull(peccoInitialize.getErrorCode());
        assertNull(peccoInitialize.getErrorMessage());
        assertNull(peccoInitialize.getErrorGroup());
    }

    /*
        This test needs manual payment from Pecco on sandbox environment. So it does not contain any assertions.
    */
    @Test
    public void should_create_pecco_payment() {
        CreatePeccoInitializeRequest request = CreatePeccoInitializeRequestBuilder.create()
                .callbackUrl("https://www.merchant.com/callback")
                .paymentGroup(PaymentGroup.LISTING.name())
                .price(new BigDecimal("1"))
                .paidPrice(new BigDecimal("10"))
                .build();

        String token = PeccoInitialize.create(request, options).getToken();

        System.out.println();

        CreatePeccoPaymentRequest peccoPaymentRequest = CreatePeccoPaymentRequestBuilder.create()
                .token(token)
                .build();

        PeccoPayment peccoPayment = PeccoPayment.create(peccoPaymentRequest, options);

        System.out.println(peccoPayment);
    }
}