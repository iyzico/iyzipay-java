package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreateCancelRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateCancelRequest;
import com.iyzipay.request.CreatePaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CancelTest extends BaseTest {

    @Test
    public void should_cancel_payment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        String paymentId = Payment.create(paymentRequest, options).getPaymentId();

        CreateCancelRequest cancelRequest = CreateCancelRequestBuilder.create()
                .paymentId(paymentId)
                .build();

        Cancel cancel = Cancel.create(cancelRequest, options);

        System.out.println(cancel);

        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(paymentId, cancel.getPaymentId());
        assertEquals(new BigDecimal("1.10000000"), cancel.getPrice());
        assertEquals(Currency.TRY.name(), cancel.getCurrency());
        assertEquals("mock00001iyziauthcd", cancel.getAuthCode());
        assertNotNull(cancel.getSystemTime());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }
}