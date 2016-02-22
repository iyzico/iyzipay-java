package com.iyzipay.model.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Payment;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrievePaymentRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RetrievePaymentSample extends Sample {

    @Test
    public void should_retrieve_payment() {
        RetrievePaymentRequest retrievePaymentRequest = new RetrievePaymentRequest();
        retrievePaymentRequest.setLocale(Locale.TR.getValue());
        retrievePaymentRequest.setConversationId("123456879");
        retrievePaymentRequest.setPaymentId("1");
        retrievePaymentRequest.setPaymentConversationId("123456789");

        Payment payment = Payment.retrieve(retrievePaymentRequest, options);

        System.out.println(payment.toString());

        assertNotNull(payment.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
        assertEquals("123456879", payment.getConversationId());
    }
}
