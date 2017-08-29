package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveCardManagementPageCardRequest;

import java.util.List;

public class CardManagementPageCard extends IyzipayResource {

    private String cardUserKey;
    private List<Card> cardDetails;

    public static CardManagementPageCard retrieve(RetrieveCardManagementPageCardRequest request, Options options) {
        return HttpClient.create().get(options.getBaseUrl() + "/v1/card-management/pages/" + request.getPageToken() + "/cards",
                getHttpHeaders(request, options),
                request,
                CardManagementPageCard.class);
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public List<Card> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(List<Card> cardDetails) {
        this.cardDetails = cardDetails;
    }
}
