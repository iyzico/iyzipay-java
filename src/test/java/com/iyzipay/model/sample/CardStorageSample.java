package com.iyzipay.model.sample;

import com.iyzipay.model.Card;
import com.iyzipay.model.CardInformation;
import com.iyzipay.model.CardList;
import com.iyzipay.model.Locale;
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
        cardInformation.setCardAlias("card alias");
        cardInformation.setCardHolderName("card holder name");
        cardInformation.setCardNumber("****************");
        cardInformation.setExpireMonth("**");
        cardInformation.setExpireYear("****");

        CreateCardRequest request = new CreateCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setEmail("email@email.com");
        request.setExternalId("external id");
        request.setCard(cardInformation);

        Card card = Card.create(request, options);

        assertNotNull(card.getConversationId());
        assertNotNull(card.getLocale());
        assertEquals(Locale.TR.getValue(), card.getLocale());

        System.out.println(card);
    }

    @Test
    public void should_create_card() {
        CardInformation cardInformation = new CardInformation();
        cardInformation.setCardAlias("card alias");
        cardInformation.setCardHolderName("card holder name");
        cardInformation.setCardNumber("****************");
        cardInformation.setExpireMonth("**");
        cardInformation.setExpireYear("****");

        CreateCardRequest request = new CreateCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardUserKey("card user key");
        request.setCard(cardInformation);

        Card card = Card.create(request, options);

        System.out.println(card);

        assertNotNull(card.getConversationId());
        assertNotNull(card.getLocale());
        assertEquals(Locale.TR.getValue(), card.getLocale());
    }

    @Test
    public void should_delete_card() {
        DeleteCardRequest request = new DeleteCardRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardToken("card token");
        request.setCardUserKey("card user key");

        Card card = Card.delete(request, options);

        System.out.println(card);

        assertNotNull(card.getConversationId());
        assertNotNull(card.getLocale());
        assertEquals(Locale.TR.getValue(), card.getLocale());
    }

    @Test
    public void should_retrieve_cards() {
        RetrieveCardListRequest request = new RetrieveCardListRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardUserKey("card user key");

        CardList cardList = CardList.retrieve(request, options);

        System.out.println(cardList);

        assertNotNull(cardList.getConversationId());
        assertNotNull(cardList.getLocale());
        assertEquals(Locale.TR.getValue(), cardList.getLocale());
    }

}
