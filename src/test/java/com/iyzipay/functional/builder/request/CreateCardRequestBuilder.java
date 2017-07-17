package com.iyzipay.functional.builder.request;

import com.iyzipay.model.CardInformation;
import com.iyzipay.request.CreateCardRequest;

public final class CreateCardRequestBuilder extends BaseRequestBuilder {

    private String email;
    private String cardUserKey;
    private CardInformation card;
    private String externalId;

    private CreateCardRequestBuilder() {
    }

    public static CreateCardRequestBuilder create() {
        return new CreateCardRequestBuilder();
    }

    public CreateCardRequestBuilder externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public CreateCardRequestBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CreateCardRequestBuilder cardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
        return this;
    }

    public CreateCardRequestBuilder card(CardInformation card) {
        this.card = card;
        return this;
    }

    public CreateCardRequest build() {
        CreateCardRequest createCardRequest = new CreateCardRequest();
        createCardRequest.setLocale(locale);
        createCardRequest.setConversationId(conversationId);
        createCardRequest.setExternalId(externalId);
        createCardRequest.setEmail(email);
        createCardRequest.setCardUserKey(cardUserKey);
        createCardRequest.setCard(card);
        return createCardRequest;
    }
}
