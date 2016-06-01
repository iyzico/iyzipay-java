package com.iyzipay.model.sample;

import com.iyzipay.model.ConnectPaymentPostAuth;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreatePaymentPostAuthRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectPostAuthSample extends Sample {

    @Test
    public void should_post_auth() {
        CreatePaymentPostAuthRequest request = new CreatePaymentPostAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");
        request.setPaidPrice(new BigDecimal("0.3"));
        request.setIp("85.34.78.112");
        request.setCurrency(Currency.TRY.name());

        ConnectPaymentPostAuth paymentPostAuth = ConnectPaymentPostAuth.create(request, options);

        System.out.println(paymentPostAuth);

        assertNotNull(paymentPostAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentPostAuth.getStatus());
        assertEquals(Locale.TR.getValue(), paymentPostAuth.getLocale());
        assertEquals("123456789", paymentPostAuth.getConversationId());
    }
}