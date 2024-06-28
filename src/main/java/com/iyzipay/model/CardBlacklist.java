package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CardBlacklistRequest;
import com.iyzipay.request.RetrieveCardBlacklistRequest;

public class CardBlacklist extends IyzipayResource {
    private String cardNumber;
    private boolean blacklisted;

    public static IyzipayResource create(CardBlacklistRequest request, Options options) {
        String path = "/cardstorage/blacklist/card";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                IyzipayResource.class);
    }

    public static IyzipayResource update(CardBlacklistRequest request, Options options) {
        String path = "/cardstorage/blacklist/card/inactive";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                IyzipayResource.class);
    }

    public static CardBlacklist retrieve(RetrieveCardBlacklistRequest request, Options options) {
        String path = "/cardstorage/blacklist/card/retrieve";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CardBlacklist.class);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }
}
