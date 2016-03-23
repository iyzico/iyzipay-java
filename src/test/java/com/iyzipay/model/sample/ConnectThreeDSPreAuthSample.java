package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateConnectThreeDSAuthRequest;
import com.iyzipay.request.CreateConnectThreeDSInitializeRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectThreeDSPreAuthSample extends Sample {

    @Test
    public void should_initialize_threeds_with_card() {
        CreateConnectThreeDSInitializeRequest request = new CreateConnectThreeDSInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBuyerEmail("email@email.com");
        request.setBuyerId("B2323");
        request.setBuyerIp("85.34.78.112");
        request.setConnectorName("connector name");
        request.setInstallment(1);
        request.setPaidPrice(new BigDecimal("1"));
        request.setPrice(new BigDecimal("1"));
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setCurrency(Currency.TRY.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setRegisterCard(0);
        request.setPaymentCard(paymentCard);

        ConnectThreeDSInitializePreAuth connectThreeDSInitializePreAuth = ConnectThreeDSInitializePreAuth.create(request, options);

        System.out.println(connectThreeDSInitializePreAuth);

        assertNotNull(connectThreeDSInitializePreAuth.getConversationId());
        assertNotNull(connectThreeDSInitializePreAuth.getLocale());
        assertEquals(Locale.TR.getValue(), connectThreeDSInitializePreAuth.getLocale());
    }

    @Test
    public void should_initialize_threeds_with_card_token() {
        CreateConnectThreeDSInitializeRequest request = new CreateConnectThreeDSInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBuyerEmail("email@email.com");
        request.setBuyerId("B2323");
        request.setBuyerIp("85.34.78.112");
        request.setConnectorName("connector name");
        request.setInstallment(1);
        request.setPaidPrice(new BigDecimal("1"));
        request.setPrice(new BigDecimal("1"));
        request.setCallbackUrl("https://www.merchant.com/callback");
        request.setCurrency(Currency.TRY.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardToken("card token");
        paymentCard.setCardUserKey("card user key");
        request.setPaymentCard(paymentCard);

        ConnectThreeDSInitializePreAuth connectThreeDSInitializePreAuth = ConnectThreeDSInitializePreAuth.create(request, options);

        System.out.println(connectThreeDSInitializePreAuth);

        assertNotNull(connectThreeDSInitializePreAuth.getConversationId());
        assertNotNull(connectThreeDSInitializePreAuth.getLocale());
        assertEquals(Locale.TR.getValue(), connectThreeDSInitializePreAuth.getLocale());
        assertEquals("123456789", connectThreeDSInitializePreAuth.getConversationId());
    }

    @Test
    public void should_auth_threeds() {
        CreateConnectThreeDSAuthRequest request = new CreateConnectThreeDSAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");

        ConnectThreeDSAuth connectThreeDSAuth = ConnectThreeDSAuth.create(request, options);

        System.out.println(connectThreeDSAuth);

        assertNotNull(connectThreeDSAuth.getConversationId());
        assertNotNull(connectThreeDSAuth.getLocale());
        assertEquals(Locale.TR.getValue(), connectThreeDSAuth.getLocale());
        assertEquals("123456789", connectThreeDSAuth.getConversationId());
    }
}
