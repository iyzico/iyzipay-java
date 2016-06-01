package com.iyzipay.model.sample;

import com.iyzipay.model.ConnectPaymentPreAuth;
import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentCard;
import com.iyzipay.request.CreateConnectPaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectPaymentPreAuthSample extends Sample {

    @Test
    public void should_pay_with_card() {
        CreateConnectPaymentRequest request = new CreateConnectPaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBuyerEmail("email@email.com");
        request.setBuyerId("B2323");
        request.setBuyerIp("85.34.78.112");
        request.setConnectorName("connector name");
        request.setInstallment(1);
        request.setPaidPrice(new BigDecimal("1"));
        request.setPrice(new BigDecimal("1"));
        request.setCurrency(Currency.TRY.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setRegisterCard(0);
        request.setPaymentCard(paymentCard);

        ConnectPaymentPreAuth connectPaymentPreAuth = ConnectPaymentPreAuth.create(request, options);

        System.out.println(connectPaymentPreAuth);

        assertNotNull(connectPaymentPreAuth.getConversationId());
        assertNotNull(connectPaymentPreAuth.getLocale());
        assertEquals(Locale.TR.getValue(), connectPaymentPreAuth.getLocale());
        assertEquals("123456789", connectPaymentPreAuth.getConversationId());
    }

    @Test
    public void should_pay_with_card_token() {
        CreateConnectPaymentRequest request = new CreateConnectPaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setBuyerEmail("email@email.com");
        request.setBuyerId("B2323");
        request.setBuyerIp("85.34.78.112");
        request.setConnectorName("connector name");
        request.setInstallment(1);
        request.setPaidPrice(new BigDecimal("1"));
        request.setPrice(new BigDecimal("1"));
        request.setCurrency(Currency.TRY.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardToken("card token");
        paymentCard.setCardUserKey("card user key");
        request.setPaymentCard(paymentCard);

        ConnectPaymentPreAuth connectPaymentPreAuth = ConnectPaymentPreAuth.create(request, options);

        System.out.println(connectPaymentPreAuth);

        assertNotNull(connectPaymentPreAuth.getConversationId());
        assertNotNull(connectPaymentPreAuth.getLocale());
        assertEquals(Locale.TR.getValue(), connectPaymentPreAuth.getLocale());
        assertEquals("123456789", connectPaymentPreAuth.getConversationId());
    }
}
