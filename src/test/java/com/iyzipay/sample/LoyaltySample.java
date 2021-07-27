package com.iyzipay.sample;

import com.iyzipay.model.Currency;
import com.iyzipay.model.Locale;
import com.iyzipay.model.loyalty.LoyaltyInquire;
import com.iyzipay.model.loyalty.LoyaltyInquireRequest;
import com.iyzipay.model.loyalty.LoyaltyPaymentCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoyaltySample extends Sample {

    @Test
    public void should_create_loyalty_mock_world_credit_card_yapi_kredi() {
        LoyaltyInquireRequest request = new LoyaltyInquireRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCurrency(Currency.TRY.name());


        LoyaltyPaymentCard paymentCard = new LoyaltyPaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5451030000000000");
        paymentCard.setExpireMonth("09");
        paymentCard.setExpireYear("2023");
        paymentCard.setCvc("123");
        request.setPaymentCard(paymentCard);

        LoyaltyInquire loyalty = LoyaltyInquire.create(request, options);
        System.out.println(loyalty);
        assertEquals("Yapı Kredi Bankası", loyalty.getCardBank());
        assertEquals("World", loyalty.getCardFamily());
        assertEquals(Locale.TR.getValue(), loyalty.getLocale());
        assertNull(loyalty.getErrorCode());
        assertNull(loyalty.getErrorMessage());
        assertNull(loyalty.getErrorGroup());
    }

    @Test
    public void should_create_loyalty_mock_credit_card_denizbank() {
        LoyaltyInquireRequest request = new LoyaltyInquireRequest();
        request.setLocale(Locale.TR.getValue());
        final String conversationId = "123456789";
        request.setConversationId(conversationId);
        request.setCurrency(Currency.TRY.name());


        LoyaltyPaymentCard paymentCard = new LoyaltyPaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5549607159333771");
        paymentCard.setExpireMonth("09");
        paymentCard.setExpireYear("2023");
        paymentCard.setCvc("123");
        request.setPaymentCard(paymentCard);


        LoyaltyInquire loyalty = LoyaltyInquire.create(request, options);
        System.out.println(loyalty);
        assertEquals("Bonus", loyalty.getCardFamily());
        assertEquals(Locale.TR.getValue(), loyalty.getLocale());
        assertEquals(conversationId, loyalty.getConversationId());
        assertNull(loyalty.getErrorCode());
        assertNull(loyalty.getErrorMessage());
        assertNull(loyalty.getErrorGroup());
    }


}
