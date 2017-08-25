package com.iyzipay.sample;

import com.iyzipay.model.CardManagementPageInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCardManagementPageInitializeRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardManagementPageSample extends Sample {

    @Test
    public void should_initialize_card_management_page() {
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

        System.out.println(cardManagementPageInitialize);

        assertEquals(Status.SUCCESS.getValue(), cardManagementPageInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), cardManagementPageInitialize.getLocale());
        assertEquals("123456789", cardManagementPageInitialize.getConversationId());
        assertNotNull(cardManagementPageInitialize.getToken());
        assertNotNull(cardManagementPageInitialize.getCardPageUrl());
        assertNotNull(cardManagementPageInitialize.getSystemTime());
        assertNull(cardManagementPageInitialize.getErrorCode());
        assertNull(cardManagementPageInitialize.getErrorMessage());
        assertNull(cardManagementPageInitialize.getErrorGroup());
    }
}
