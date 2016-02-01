package com.iyzipay.model.sample;

import com.iyzipay.Request;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentRetrieval;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrievePaymentRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RetrievePaymentSample extends Sample {

    @Test
    public void should_retrieve_payment_by_payment_id() {
        RetrievePaymentRequest request = new RetrievePaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("10");

        PaymentRetrieval paymentRetrieval = PaymentRetrieval.retrieveByPaymentId(request, options);

        System.out.println(paymentRetrieval);


        assertNotNull(paymentRetrieval.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentRetrieval.getStatus());
        assertEquals(Locale.TR.getValue(), paymentRetrieval.getLocale());
    }

    @Test
    public void should_retrieve_payment_by_conversation_id() {
        RetrievePaymentRequest request = new RetrievePaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setPaymentConversationId("123456789");

        PaymentRetrieval paymentRetrieval = PaymentRetrieval.retrieveByConversationId(request, options);

        System.out.println(paymentRetrieval);

        assertNotNull(paymentRetrieval.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentRetrieval.getStatus());
        assertEquals(Locale.TR.getValue(), paymentRetrieval.getLocale());
    }
}
