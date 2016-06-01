package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateBasicPaymentRequest;
import com.iyzipay.request.CreateThreedsPaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasicThreedsSample extends Sample {

    @Test
    public void should_initialize_threeds_with_card() {
        CreateBasicPaymentRequest request = new CreateBasicPaymentRequest();
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

        BasicThreedsInitialize basicThreeDSInitialize = BasicThreedsInitialize.create(request, options);

        System.out.println(basicThreeDSInitialize);

        assertNotNull(basicThreeDSInitialize.getConversationId());
        assertNotNull(basicThreeDSInitialize.getLocale());
        assertEquals(Locale.TR.getValue(), basicThreeDSInitialize.getLocale());
    }

    @Test
    public void should_initialize_threeds_with_card_token() {
        CreateBasicPaymentRequest request = new CreateBasicPaymentRequest();
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

        BasicThreedsInitialize basicThreeDSInitialize = BasicThreedsInitialize.create(request, options);

        System.out.println(basicThreeDSInitialize);

        assertNotNull(basicThreeDSInitialize.getConversationId());
        assertNotNull(basicThreeDSInitialize.getLocale());
        assertEquals(Locale.TR.getValue(), basicThreeDSInitialize.getLocale());
        assertEquals("123456789", basicThreeDSInitialize.getConversationId());
    }

    @Test
    public void should_auth_threeds() {
        CreateThreedsPaymentRequest request = new CreateThreedsPaymentRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");

        BasicThreedsPayment basicThreeDS = BasicThreedsPayment.create(request, options);

        System.out.println(basicThreeDS);

        assertNotNull(basicThreeDS.getConversationId());
        assertNotNull(basicThreeDS.getLocale());
        assertEquals(Locale.TR.getValue(), basicThreeDS.getLocale());
        assertEquals("123456789", basicThreeDS.getConversationId());
    }
}
