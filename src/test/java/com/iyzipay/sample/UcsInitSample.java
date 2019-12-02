package com.iyzipay.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.model.universalcardstorage.UcsInitResource;
import com.iyzipay.request.InitUcsRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UcsInitSample extends Sample {

    @Test
    public void should_initialize_ucs() {
        InitUcsRequest request = new InitUcsRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setEmail("test@iyzico.com");
        request.setGsmNumber("+905350000000");

        UcsInitResource response = UcsInitResource.create(request, options);

        System.out.println(response);

        assertEquals(Status.SUCCESS.getValue(), response.getStatus());
        assertEquals(Locale.TR.getValue(), response.getLocale());
        assertEquals("123456789", response.getConversationId());
        assertNotNull(response.getGsmNumber());
        assertNotNull(response.getMaskedGsmNumber());
        assertNotNull(response.getMerchantName());
        assertNotNull(response.getUcsToken());
        assertNotNull(response.getScript());
        assertNotNull(response.getScriptType());
    }
}
