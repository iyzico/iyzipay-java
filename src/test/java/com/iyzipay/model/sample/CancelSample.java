package com.iyzipay.model.sample;

import com.iyzipay.model.Cancel;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCancelRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CancelSample extends Sample {

    @Test
    public void should_cancel_payment() {
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");
        request.setIp("85.34.78.112");

        Cancel cancel = Cancel.create(request, options);

        System.out.println(cancel);

        assertNotNull(cancel.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), cancel.getStatus());
        assertEquals(Locale.TR.getValue(), cancel.getLocale());
        assertEquals("123456789", cancel.getConversationId());
    }
}
