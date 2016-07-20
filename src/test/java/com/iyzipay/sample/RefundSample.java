package com.iyzipay.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateRefundRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefundSample extends Sample {

    @Test
    public void should_refund() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("1");
        request.setPrice(new BigDecimal("0.1"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertNotNull(refund.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertEquals("123456789", refund.getConversationId());
    }

    @Test
    public void should_refund_charged_from_merchant() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("1");
        request.setPrice(new BigDecimal("0.1"));
        request.setCurrency(Currency.TRY.name());
        request.setIp("85.34.78.112");

        RefundChargedFromMerchant refundChargedFromMerchant = RefundChargedFromMerchant.create(request, options);

        System.out.println(refundChargedFromMerchant);

        assertNotNull(refundChargedFromMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), refundChargedFromMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), refundChargedFromMerchant.getLocale());
        assertEquals("123456789", refundChargedFromMerchant.getConversationId());
    }
}
