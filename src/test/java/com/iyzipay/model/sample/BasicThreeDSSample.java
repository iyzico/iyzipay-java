package com.iyzipay.model.sample;

import com.iyzipay.model.BasicThreeDS;
import com.iyzipay.model.BasicThreeDSInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.PaymentCard;
import com.iyzipay.request.CreateBasicPaymentRequest;
import com.iyzipay.request.CreateThreeDSRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasicThreeDSSample extends Sample {

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

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setRegisterCard(0);
        request.setPaymentCard(paymentCard);

        BasicThreeDSInitialize basicThreeDSInitialize = BasicThreeDSInitialize.create(request, options);

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

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardToken("card token");
        paymentCard.setCardUserKey("card user key");
        request.setPaymentCard(paymentCard);

        BasicThreeDSInitialize basicThreeDSInitialize = BasicThreeDSInitialize.create(request, options);

        System.out.println(basicThreeDSInitialize);

        assertNotNull(basicThreeDSInitialize.getConversationId());
        assertNotNull(basicThreeDSInitialize.getLocale());
        assertEquals(Locale.TR.getValue(), basicThreeDSInitialize.getLocale());
        assertEquals("123456789", basicThreeDSInitialize.getConversationId());
    }

    @Test
    public void should_auth_threeds() {
        CreateThreeDSRequest request = new CreateThreeDSRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("1");

        BasicThreeDS basicThreeDS = BasicThreeDS.create(request, options);

        System.out.println(basicThreeDS);

        assertNotNull(basicThreeDS.getConversationId());
        assertNotNull(basicThreeDS.getLocale());
        assertEquals(Locale.TR.getValue(), basicThreeDS.getLocale());
        assertEquals("123456789", basicThreeDS.getConversationId());
    }
}
