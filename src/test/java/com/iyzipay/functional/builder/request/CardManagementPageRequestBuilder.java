package com.iyzipay.functional.builder.request;

import com.iyzipay.request.CreateCardManagementPageInitializeRequest;

public class CardManagementPageRequestBuilder extends BaseRequestBuilder {

    private Boolean addNewCardEnabled = Boolean.TRUE;
    private Boolean validateNewCard = Boolean.TRUE;
    private String externalId = "123123";
    private String email = "test@iyzico.com";
    private String cardUserKey;
    private String callbackUrl = "merchant.com/callbackurl";
    private Boolean debitCardAllowed = Boolean.TRUE;

    private CardManagementPageRequestBuilder() {
    }

    public static CardManagementPageRequestBuilder create() {
        return new CardManagementPageRequestBuilder();
    }

    public CardManagementPageRequestBuilder addNewCardEnabled(Boolean addNewCardEnabled) {
        this.addNewCardEnabled = addNewCardEnabled;
        return this;
    }

    public CardManagementPageRequestBuilder validateNewCard(Boolean validateNewCard) {
        this.validateNewCard = validateNewCard;
        return this;
    }

    public CardManagementPageRequestBuilder externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public CardManagementPageRequestBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CardManagementPageRequestBuilder cardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
        return this;
    }

    public CardManagementPageRequestBuilder callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public CardManagementPageRequestBuilder debitCardAllowed(Boolean debitCardAllowed) {
        this.debitCardAllowed = debitCardAllowed;
        return this;
    }

    public CreateCardManagementPageInitializeRequest build(){
        CreateCardManagementPageInitializeRequest createCardManagementPageInitializeRequest = new CreateCardManagementPageInitializeRequest();
        createCardManagementPageInitializeRequest.setAddNewCardEnabled(this.addNewCardEnabled);
        createCardManagementPageInitializeRequest.setCallbackUrl(this.callbackUrl);
        createCardManagementPageInitializeRequest.setCardUserKey(this.cardUserKey);
        createCardManagementPageInitializeRequest.setDebitCardAllowed(this.debitCardAllowed);
        createCardManagementPageInitializeRequest.setValidateNewCard(this.validateNewCard);
        createCardManagementPageInitializeRequest.setExternalId(this.externalId);
        createCardManagementPageInitializeRequest.setEmail(this.email);
        createCardManagementPageInitializeRequest.setConversationId(this.conversationId);
        createCardManagementPageInitializeRequest.setLocale(this.locale);
        return createCardManagementPageInitializeRequest;
    }
}
