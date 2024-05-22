package com.iyzipay.model;

import java.util.List;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveCardListRequest;

public class CardList extends IyzipayResource {

    private String cardUserKey;
    private List<Card> cardDetails;

    public static CardList retrieve(RetrieveCardListRequest request, Options options) {
        String path = "/cardstorage/cards";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CardList.class);
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
