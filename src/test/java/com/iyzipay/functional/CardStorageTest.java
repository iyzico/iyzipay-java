package com.iyzipay.functional;

import com.iyzipay.functional.builder.CardInformationBuilder;
import com.iyzipay.functional.builder.request.CreateCardRequestBuilder;
import com.iyzipay.functional.util.RandomGenerator;
import com.iyzipay.model.*;
import com.iyzipay.request.CreateCardRequest;
import com.iyzipay.request.DeleteCardRequest;
import com.iyzipay.request.RetrieveCardListRequest;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.*;

public class CardStorageTest extends BaseTest {

    @Test
    public void should_create_user_and_add_card() {
        String externalUserId = RandomGenerator.randomId();
        CardInformation cardInformation = CardInformationBuilder.create()
                .build();

        CreateCardRequest createCardRequest = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .externalId(externalUserId)
                .email("email@email.com")
                .build();

        Card card = Card.create(createCardRequest, options);

        System.out.println(card);

        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertNotNull(card.getSystemTime());
        assertEquals("123456789", card.getConversationId());
        assertEquals("email@email.com", card.getEmail());
        assertEquals("552879", card.getBinNumber());
        assertEquals("card alias", card.getCardAlias());
        assertEquals("CREDIT_CARD", card.getCardType());
        assertEquals("MASTER_CARD", card.getCardAssociation());
        assertEquals("Paraf", card.getCardFamily());
        assertEquals("Halk Bankası", card.getCardBankName());
        assertTrue(card.getCardBankCode().equals(12L));
    }

    @Test
    public void should_create_user_and_add_card_when_metadata_exist() {
        String externalUserId = RandomGenerator.randomId();
        Map<String, String> metadata = Collections.singletonMap("CUT_OFF_DAY","15");

        CardInformation cardInformation = CardInformationBuilder.create()
                .metadata(metadata)
                .build();

        CreateCardRequest createCardRequest = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .externalId(externalUserId)
                .email("email@email.com")
                .build();

        System.out.println(createCardRequest);

        Card card = Card.create(createCardRequest, options);

        System.out.println(card);

        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertNotNull(card.getSystemTime());
        assertEquals("123456789", card.getConversationId());
        assertEquals("email@email.com", card.getEmail());
        assertEquals("552879", card.getBinNumber());
        assertEquals("card alias", card.getCardAlias());
        assertEquals("CREDIT_CARD", card.getCardType());
        assertEquals("MASTER_CARD", card.getCardAssociation());
        assertEquals("Paraf", card.getCardFamily());
        assertEquals(card.getMetadata().get("CUT_OFF_DAY"), "15");
        assertEquals("Halk Bankası", card.getCardBankName());
        assertTrue(card.getCardBankCode().equals(12L));
    }

    @Test
    public void should_create_card_and_add_card_to_existing_user() {
        String externalUserId = RandomGenerator.randomId();
        CardInformation cardInformation = CardInformationBuilder.create()
                .build();

        CreateCardRequest cardRequest = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .externalId(externalUserId)
                .email("email@email.com")
                .build();

        Card firstCard = Card.create(cardRequest, options);
        String cardUserKey = firstCard.getCardUserKey();

        CreateCardRequest request = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .cardUserKey(cardUserKey)
                .externalId(externalUserId)
                .build();

        Card card = Card.create(request, options);

        System.out.println(card);

        assertEquals(Locale.TR.getValue(), card.getLocale());
        assertEquals(Status.SUCCESS.getValue(), card.getStatus());
        assertNotNull(card.getSystemTime());
        assertEquals("123456789", card.getConversationId());
        assertEquals("552879", card.getBinNumber());
        assertEquals("card alias", card.getCardAlias());
        assertEquals("CREDIT_CARD", card.getCardType());
        assertEquals("MASTER_CARD", card.getCardAssociation());
        assertEquals("Paraf", card.getCardFamily());
        assertEquals("Halk Bankası", card.getCardBankName());
        assertEquals(externalUserId, card.getExternalId());
        assertTrue(card.getCardBankCode().equals(12L));
    }

    @Test
    public void should_delete_card() {
        Card card = createCard();

        DeleteCardRequest deleteCardRequest = new DeleteCardRequest();
        deleteCardRequest.setCardToken(card.getCardToken());
        deleteCardRequest.setCardUserKey(card.getCardUserKey());

        Card deletedCard = Card.delete(deleteCardRequest, options);

        System.out.println(deletedCard);

        assertEquals(Status.SUCCESS.getValue(), deletedCard.getStatus());
        assertEquals(Locale.TR.getValue(), deletedCard.getLocale());
        assertNotNull(deletedCard.getSystemTime());
        assertNull(deletedCard.getErrorCode());
        assertNull(deletedCard.getErrorMessage());
        assertNull(deletedCard.getErrorGroup());
        assertNull(deletedCard.getBinNumber());
        assertNull(deletedCard.getCardAlias());
        assertNull(deletedCard.getCardType());
        assertNull(deletedCard.getCardAssociation());
        assertNull(deletedCard.getCardFamily());
        assertNull(deletedCard.getCardBankName());
        assertNull(deletedCard.getCardBankCode());
        assertNull(deletedCard.getCardUserKey());
        assertNull(deletedCard.getCardToken());
        assertNull(deletedCard.getEmail());
        assertNull(deletedCard.getExternalId());
    }

    @Test
    public void should_retrieve_card() {
        Card card = createCard();

        RetrieveCardListRequest request = new RetrieveCardListRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setCardUserKey(card.getCardUserKey());

        CardList cardList = CardList.retrieve(request, options);

        System.out.println(cardList);

        assertEquals(Status.SUCCESS.getValue(), cardList.getStatus());
        assertEquals(Locale.TR.getValue(), cardList.getLocale());
        assertEquals("123456789", cardList.getConversationId());
        assertNotNull(cardList.getSystemTime());
        assertNull(cardList.getErrorCode());
        assertNull(cardList.getErrorMessage());
        assertNull(cardList.getErrorGroup());
        assertNotNull(cardList.getCardDetails());
        assertFalse(cardList.getCardDetails().isEmpty());
        assertNotNull(cardList.getCardUserKey());
    }

    private Card createCard() {
        CardInformation cardInformation = CardInformationBuilder.create()
                .build();

        CreateCardRequest cardRequest = CreateCardRequestBuilder.create()
                .card(cardInformation)
                .email("email@email.com")
                .build();

        return Card.create(cardRequest, options);
    }
}