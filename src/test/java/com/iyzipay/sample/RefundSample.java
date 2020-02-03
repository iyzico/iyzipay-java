package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateAmountBasedRefundRequest;
import com.iyzipay.request.CreateRefundRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RefundSample extends Sample {

    @Test
    public void should_refund_payment() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("1");
        request.setPrice(new BigDecimal("0.5"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertEquals("123456789", refund.getConversationId());
        assertNotNull(refund.getSystemTime());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }

    @Test
    public void should_amount_based_refund_payment() {
        CreateAmountBasedRefundRequest request = new CreateAmountBasedRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setIp("85.34.78.112");
        request.setPrice(new BigDecimal("0.5"));
        request.setPaymentId("1");

        Refund amountBasedRefund = Refund.createAmountBasedRefund(request, options);

        System.out.println(amountBasedRefund);

        assertEquals(Status.SUCCESS.getValue(), amountBasedRefund.getStatus());
        assertEquals(amountBasedRefund.getPrice(), request.getPrice());
        assertEquals(Locale.TR.getValue(), amountBasedRefund.getLocale());
        assertEquals("123456789", amountBasedRefund.getConversationId());
        assertNotNull(amountBasedRefund.getSystemTime());
        assertNull(amountBasedRefund.getErrorCode());
        assertNull(amountBasedRefund.getErrorMessage());
        assertNull(amountBasedRefund.getErrorGroup());
    }

    @Test
    public void should_refund_payment_with_reason() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("13");
        request.setPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.DOUBLE_PAYMENT);
        request.setDescription("customer requested for default sample");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertEquals("123456789", refund.getConversationId());
        assertNotNull(refund.getSystemTime());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }

    @Test
    public void should_refund_fraudulent_payment() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("2");
        request.setPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.FRAUD);
        request.setDescription("stolen card request with 11000 try payment for default sample");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertEquals("123456789", refund.getConversationId());
        assertNotNull(refund.getSystemTime());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }
}
