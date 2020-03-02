package com.iyzipay.sample;

import com.iyzipay.model.Cancel;
import com.iyzipay.model.Locale;
import com.iyzipay.model.RefundReason;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCancelRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class CancelSample extends Sample {

    @Test
    public void should_cancel_payment() {
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("2");
        request.setIp("85.34.78.112");

        Cancel cancel = Cancel.create(request, options);

        System.out.println(cancel);

        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals("123456789", cancel.getConversationId());
        assertNotEquals(0, cancel.getSystemTime());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }

    @Test
    public void should_cancel_payment_with_reason() {
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("4");
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.DOUBLE_PAYMENT);
        request.setDescription("customer requested for default sample");

        Cancel cancel = Cancel.create(request, options);

        System.out.println(cancel);

        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals("123456789", cancel.getConversationId());
        assertNotEquals(0, cancel.getSystemTime());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }

    @Test
    public void should_cancel_fraudulent_payment() {
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("4");
        request.setIp("85.34.78.112");
        request.setReason(RefundReason.FRAUD);
        request.setDescription("stolen card request with 11000 try payment for default sample");

        Cancel cancel = Cancel.create(request, options);

        System.out.println(cancel);

        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals("123456789", cancel.getConversationId());
        assertNotEquals(0, cancel.getSystemTime());
        assertNull(cancel.getErrorCode());
        assertNull(cancel.getErrorMessage());
        assertNull(cancel.getErrorGroup());
    }
}
