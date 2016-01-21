package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveCardListRequest;

import java.util.List;

public class CardList extends IyzipayResource {

    private String cardUserKey;
    private List<Card> cardDetails;

    public static CardList retrieve(RetrieveCardListRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/cardstorage/cards",
                        getHttpHeaders(request, options),
                        request,
                        CardList.class)
                .getBody();
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
