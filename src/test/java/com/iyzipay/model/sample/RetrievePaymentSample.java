package com.iyzipay.model.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Payment;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrievePaymentByConvIdRequest;
import com.iyzipay.request.RetrievePaymentByIdRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RetrievePaymentSample extends Sample {

    @Test
    public void should_retrieve_payment_by_payment_id() {
        RetrievePaymentByIdRequest request = new RetrievePaymentByIdRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("10");

        Payment payment = Payment.retrieve(request, options);

        System.out.println(payment);

        assertNotNull(payment.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), payment.getStatus());
        assertEquals(Locale.TR.getValue(), payment.getLocale());
    }

    @Test
    public void should_retrieve_payment_by_conversation_id() {
        RetrievePaymentByConvIdRequest request = new RetrievePaymentByConvIdRequest();
        request.setLocale(Locale.TR.getValue());
        request.setPaymentConversationId("123456789");

        Payment paymentRetrieval = Payment.retrieve(request, options);

        System.out.println(paymentRetrieval);

        assertNotNull(paymentRetrieval.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentRetrieval.getStatus());
        assertEquals(Locale.TR.getValue(), paymentRetrieval.getLocale());
    }
}
