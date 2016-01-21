package com.iyzipay.model.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Refund;
import com.iyzipay.model.RefundChargedFromMerchant;
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
        request.setPaymentTransactionId("12345");
        request.setPrice(new BigDecimal("1"));
        request.setIp("127.0.0.1");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertNotNull(refund.getConversationId());
        assertNotNull(refund.getLocale());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
    }

    @Test
    public void should_refund_charged_from_merchant() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("12345");
        request.setPrice(new BigDecimal("1"));
        request.setIp("127.0.0.1");

        RefundChargedFromMerchant refundChargedFromMerchant = RefundChargedFromMerchant.create(request, options);

        System.out.println(refundChargedFromMerchant);

        assertNotNull(refundChargedFromMerchant.getConversationId());
        assertNotNull(refundChargedFromMerchant.getLocale());
        assertEquals(Locale.TR.getValue(), refundChargedFromMerchant.getLocale());
    }
}
