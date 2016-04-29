package com.iyzipay.model.sample;

import com.iyzipay.model.BasicPaymentPostAuth;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreatePaymentPostAuthRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasicPaymentPostAuthSample extends Sample {

    @Test
    public void should_post_auth() {
        CreatePaymentPostAuthRequest request = new CreatePaymentPostAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");
        request.setPaidPrice(new BigDecimal("0.3"));
        request.setIp("85.34.78.112");

        BasicPaymentPostAuth basicPaymentPostAuth = BasicPaymentPostAuth.create(request, options);

        System.out.println(basicPaymentPostAuth);

        assertNotNull(basicPaymentPostAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), basicPaymentPostAuth.getStatus());
        assertEquals(Locale.TR.getValue(), basicPaymentPostAuth.getLocale());
        assertEquals("123456789", basicPaymentPostAuth.getConversationId());
    }
}
