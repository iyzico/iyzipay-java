package com.iyzipay.functional;

import com.iyzipay.functional.builder.request.CardManagementPageRequestBuilder;
import com.iyzipay.model.CardManagementPageInitialize;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCardManagementPageInitializeRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardManagementPageTest extends BaseTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        options.setBaseUrl("https://sandbox-cm.iyzipay.com");
    }

    @Test
    public void should_initialize_card_management_page() throws Exception {
        CreateCardManagementPageInitializeRequest request = CardManagementPageRequestBuilder.create().build();

        CardManagementPageInitialize cardManagementPageInitialize = CardManagementPageInitialize.create(request, options);

        System.out.println(cardManagementPageInitialize);

        assertEquals(Status.SUCCESS.getValue(), cardManagementPageInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), cardManagementPageInitialize.getLocale());
        assertEquals("123456789", cardManagementPageInitialize.getConversationId());
        assertEquals("123123", cardManagementPageInitialize.getExternalId());
        assertNotNull(cardManagementPageInitialize.getToken());
        assertNotNull(cardManagementPageInitialize.getCardPageUrl());
        assertNull(cardManagementPageInitialize.getErrorCode());
        assertNull(cardManagementPageInitialize.getErrorMessage());
        assertNull(cardManagementPageInitialize.getErrorGroup());
    }

    @Test
    public void should_not_initialize_card_management_page_when_callbackUrl_not_exist() throws Exception {
        CreateCardManagementPageInitializeRequest request = CardManagementPageRequestBuilder.create().callbackUrl("").build();

        CardManagementPageInitialize cardManagementPageInitialize = CardManagementPageInitialize.create(request, options);

        System.out.println(cardManagementPageInitialize);

        assertEquals(Status.FAILURE.getValue(), cardManagementPageInitialize.getStatus());
        assertNull(cardManagementPageInitialize.getExternalId());
        assertNull(cardManagementPageInitialize.getConversationId());
        assertNull(cardManagementPageInitialize.getErrorGroup());
        assertNull(cardManagementPageInitialize.getToken());
        assertNull(cardManagementPageInitialize.getCardPageUrl());
        assertEquals("Callback url gönderilmesi zorunludur", cardManagementPageInitialize.getErrorMessage());
        assertEquals("23", cardManagementPageInitialize.getErrorCode());
    }
}
