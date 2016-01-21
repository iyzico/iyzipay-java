package com.iyzipay.model.sample;

import com.iyzipay.model.Cancel;
import com.iyzipay.model.Locale;
import com.iyzipay.request.CreateCancelRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CancelSample extends Sample {

    @Test
    public void should_cancel_payment(){
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("12345");
        request.setIp("127.0.0.1");

        Cancel cancel = Cancel.create(request, options);

        System.out.println(cancel);

        assertNotNull(cancel.getConversationId());
        assertNotNull(cancel.getLocale());
        assertEquals(Locale.TR.getValue(), cancel.getLocale());
    }

}
