package com.iyzipay.model.sample;

import com.iyzipay.model.ConnectRefund;
import com.iyzipay.model.Locale;
import com.iyzipay.request.CreateRefundRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectRefundSample extends Sample {

    @Test
    public void should_refund_payment(){
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("123456");
        request.setPrice(new BigDecimal("1.0"));
        request.setIp("127.0.0.1");

        ConnectRefund connectRefund = ConnectRefund.create(request, options);

        System.out.println(connectRefund);

        assertNotNull(connectRefund.getConversationId());
        assertNotNull(connectRefund.getLocale());
        assertEquals(Locale.TR.getValue(), connectRefund.getLocale());
    }
}
