package com.iyzipay.sample;

import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Refund;
import com.iyzipay.model.RefundReason;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateRefundRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

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
        assertNotEquals(0, refund.getSystemTime());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
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
        assertNotEquals(0, refund.getSystemTime());
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
        assertNotEquals(0, refund.getSystemTime());
        assertNull(refund.getErrorCode());
        assertNull(refund.getErrorMessage());
        assertNull(refund.getErrorGroup());
    }
}
