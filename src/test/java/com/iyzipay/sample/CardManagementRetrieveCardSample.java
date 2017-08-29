package com.iyzipay.sample;

import com.iyzipay.model.CardManagementPageCard;
import com.iyzipay.model.CardManagementPageInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCardManagementPageInitializeRequest;
import com.iyzipay.request.RetrieveCardManagementPageCardRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CardManagementRetrieveCardSample extends Sample {

    @Test
    public void should_retrieve_card_management_page_cards() {
        CreateCardManagementPageInitializeRequest request = new CreateCardManagementPageInitializeRequest();
        request.setCallbackUrl("https://merchant-callback.com");
        request.setEmail("merchant@email.com");
        request.setExternalId("123456789");
        request.setConversationId("123456789");
        request.setAddNewCardEnabled(Boolean.TRUE);
        request.setValidateNewCard(Boolean.FALSE);
        request.setCardUserKey("card user key");
        request.setLocale(Locale.TR.getValue());

        CardManagementPageInitialize cardManagementPageInitialize = CardManagementPageInitialize.create(request, options);

        RetrieveCardManagementPageCardRequest retrieveCardManagementPageCardRequest = new RetrieveCardManagementPageCardRequest();
        retrieveCardManagementPageCardRequest.setPageToken(cardManagementPageInitialize.getToken());
        retrieveCardManagementPageCardRequest.setLocale(cardManagementPageInitialize.getLocale());
        retrieveCardManagementPageCardRequest.setConversationId(cardManagementPageInitialize.getConversationId());

        CardManagementPageCard cardManagementPageCard = CardManagementPageCard.retrieve(retrieveCardManagementPageCardRequest, options);

        assertEquals(Status.SUCCESS.getValue(), cardManagementPageCard.getStatus());
        assertEquals(Locale.TR.getValue(), cardManagementPageCard.getLocale());
        assertNotNull(cardManagementPageCard.getSystemTime());
        assertNull(cardManagementPageCard.getErrorCode());
        assertNull(cardManagementPageCard.getErrorMessage());
        assertNull(cardManagementPageCard.getErrorGroup());
        assertNotNull(cardManagementPageCard);
    }
}
