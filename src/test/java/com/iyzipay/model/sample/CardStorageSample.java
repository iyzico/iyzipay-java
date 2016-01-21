package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.DeleteCardRequest;
import com.iyzipay.request.RetrieveCardListRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardStorageSample extends Sample {

    @Test
    public void should_create_user_and_add_card() {
        CardInformation cardInformation = new CardInformation();
        cardInformation.setCardAlias("myAlias");
        cardInformation.setCardHolderName("John Doe");
        cardInformation.setCardNumber("5528790000000008");
        cardInformation.setExpireMonth("12");
        cardInformation.setExpireYear("2030");

        CreateCardRequest request = new CreateCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setEmail("email@email.com");
        request.setExternalId("external id");
        request.setCard(cardInformation);

        Card card = Card.create(request, options);

        System.out.println(card);

        assertNotNull(card.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals("123456789", card.getConversationId());
    }

    @Test
    public void should_create_card() {
        CardInformation cardInformation = new CardInformation();
        cardInformation.setCardAlias("myAlias");
        cardInformation.setCardHolderName("John Doe");
        cardInformation.setCardNumber("5528790000000008");
        cardInformation.setExpireMonth("12");
        cardInformation.setExpireYear("2030");

        CreateCardRequest request = new CreateCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardUserKey("myCardUserKey");
        request.setCard(cardInformation);

        Card card = Card.create(request, options);

        System.out.println(card);

        assertNotNull(card.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals("123456789", card.getConversationId());
    }

    @Test
    public void should_delete_card() {
        DeleteCardRequest request = new DeleteCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardToken("myCardToken");
        request.setCardUserKey("myCardUserKey");

        Card card = Card.delete(request, options);

        System.out.println(card);

        assertNotNull(card.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals("123456789", card.getConversationId());
    }

    @Test
    public void should_retrieve_cards() {
        RetrieveCardListRequest request = new RetrieveCardListRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardUserKey("myCardUserKey");

        CardList cardList = CardList.retrieve(request, options);

        System.out.println(cardList);

        assertNotNull(cardList.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), cardList.getStatus());
        assertEquals(Locale.TR.getValue(), cardList.getLocale());
        assertEquals("123456789", cardList.getConversationId());
    }
}
