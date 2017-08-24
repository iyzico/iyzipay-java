package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CardManagementPageResource extends IyzipayResource {

    private String externalId;
    private String token;
    private String cardPageUrl;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCardPageUrl() {
        return cardPageUrl;
    }

    public void setCardPageUrl(String cardPageUrl) {
        this.cardPageUrl = cardPageUrl;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
