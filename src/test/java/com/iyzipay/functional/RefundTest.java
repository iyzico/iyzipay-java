package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CreatePaymentRequestBuilder;
import com.iyzipay.model.*;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.CreateRefundRequest;
import com.iyzipay.request.CreateRefundV2Request;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RefundTest extends StandardBaseTest {

    @Test
    public void should_refund_payment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        Payment payment = Payment.create(paymentRequest, options);

        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId(payment.getPaymentItems().get(0).getPaymentTransactionId());
        request.setPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertTrue(refund.verifySignature(options.getSecretKey()));
        assertEquals("123456789", refund.getConversationId());
        assertEquals(payment.getPaymentId(), refund.getPaymentId());
        assertEquals(payment.getPaymentItems().get(0).getPaymentTransactionId(), refund.getPaymentTransactionId());
        assertEquals(new BigDecimal("0.2"), refund.getPrice());
        assertNotEquals(0, refund.getSystemTime());
        assertNotNull(refund.getHostReference());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }

    @Test
    public void should_refund_fraudulent_payment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        Payment payment = Payment.create(paymentRequest, options);

        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId(payment.getPaymentItems().get(0).getPaymentTransactionId());
        request.setPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.FRAUD);
        request.setDescription("stolen card request with 11000 try payment for default sample");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertTrue(refund.verifySignature(options.getSecretKey()));
        assertEquals("123456789", refund.getConversationId());
        assertEquals(payment.getPaymentId(), refund.getPaymentId());
        assertEquals(payment.getPaymentItems().get(0).getPaymentTransactionId(), refund.getPaymentTransactionId());
        assertEquals(new BigDecimal("0.2"), refund.getPrice());
        assertNotEquals(0, refund.getSystemTime());
        assertNotNull(refund.getHostReference());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }

    @Test
    public void should_refund_v2_payment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequestBuilder.create()
                .standardListingPayment()
                .build();

        Payment payment = Payment.create(paymentRequest, options);

        CreateRefundV2Request request = new CreateRefundV2Request();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId(payment.getPaymentId());
        request.setPrice(new BigDecimal("1.1"));
        request.setIp("85.34.78.112");

        Refund refund = Refund.createV2(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertTrue(payment.verifySignature(options.getSecretKey()));
        assertTrue(refund.verifySignature(options.getSecretKey()));
        assertEquals("123456789", refund.getConversationId());
        assertEquals(payment.getPaymentId(), refund.getPaymentId());
        assertNotEquals(0, refund.getSystemTime());
        assertNotNull(refund.getHostReference());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }
}