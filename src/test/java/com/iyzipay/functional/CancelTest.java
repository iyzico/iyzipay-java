package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreateCancelRequestBuilder;
import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.model.Cancel;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Payment;
import com.iyzipay.model.RefundReason;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCancelRequest;
import com.iyzipay.request.CreatePaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        assertNotNull(cancel.getAuthCode());
        assertNotEquals(0, cancel.getSystemTime());
        assertNotNull(cancel.getHostReference());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }

    @Test
    public void should_cancel_fraudulent_payment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        String paymentId = Payment.create(paymentRequest, options).getPaymentId();

        CreateCancelRequest cancelRequest = CreateCancelRequestBuilder.create()
                .paymentId(paymentId)
                .build();
        cancelRequest.setReason(RefundReason.FRAUD);
        cancelRequest.setDescription("stolen card request with 11000 try payment for default sample");

        Cancel cancel = Cancel.create(cancelRequest, options);

        System.out.println(cancel);

        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(paymentId, cancel.getPaymentId());
        assertEquals(new BigDecimal("1.10000000"), cancel.getPrice());
        assertEquals(Currency.TRY.name(), cancel.getCurrency());
        assertNotNull(cancel.getAuthCode());
        assertNotNull(cancel.getSystemTime());
        assertNotNull(cancel.getHostReference());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }
}