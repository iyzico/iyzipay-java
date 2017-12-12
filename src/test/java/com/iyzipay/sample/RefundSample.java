package com.iyzipay.sample;

import com.iyzipay.model.*;
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
    public void should_refund_fraudulent_payment() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("5");
        request.setPrice(new BigDecimal("0.2"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.FRAUD);
        request.setDescription("Stolen Card");

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
