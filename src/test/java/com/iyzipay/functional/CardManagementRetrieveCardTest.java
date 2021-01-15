package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CardManagementPageRequestBuilder;
import com.iyzipay.functional.builder.request.CardManagementRetrieveCardBuilder;
import com.iyzipay.model.CardManagementPageCard;
import com.iyzipay.model.CardManagementPageInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCardManagementPageInitializeRequest;
import com.iyzipay.request.RetrieveCardManagementPageCardRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CardManagementRetrieveCardTest extends BaseTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        options.setBaseUrl("https://sandbox-cm.iyzipay.com");
    }

    @Test
    public void should_retrieve_cards() {
        // given
        CreateCardManagementPageInitializeRequest initializeRequest = CardManagementPageRequestBuilder.create().build();
        CardManagementPageInitialize cardManagementPageInitialize = CardManagementPageInitialize.create(initializeRequest, options);

        RetrieveCardManagementPageCardRequest retrieveCardRequest = CardManagementRetrieveCardBuilder.create()
                .pageToken(cardManagementPageInitialize.getToken())
                .build();

        //when
        CardManagementPageCard cardManagementPageCard = CardManagementPageCard.retrieve(retrieveCardRequest, options);

        System.out.println(cardManagementPageCard);

        //then
        assertEquals(Status.SUCCESS.getValue(), cardManagementPageCard.getStatus());
        assertEquals(Locale.TR.getValue(), cardManagementPageCard.getLocale());
        assertNull(cardManagementPageCard.getErrorCode());
        assertNull(cardManagementPageCard.getErrorMessage());
        assertNull(cardManagementPageCard.getErrorGroup());
        assertNotNull(cardManagementPageCard);
    }

    @Test
    public void should_not_retrieve_cards_when_pageToken_is_not_exist() {
        RetrieveCardManagementPageCardRequest retrieveCardRequest = CardManagementRetrieveCardBuilder.create()
                .pageToken(UUID.randomUUID().toString())
                .build();

        CardManagementPageCard cardManagementPageCard = CardManagementPageCard.retrieve(retrieveCardRequest, options);

        System.out.println(cardManagementPageCard);

        assertEquals(Status.SUCCESS.getValue(), cardManagementPageCard.getStatus());
        assertNull(cardManagementPageCard.getCardUserKey());
        assertEquals(0, cardManagementPageCard.getCardDetails().size());
    }
}