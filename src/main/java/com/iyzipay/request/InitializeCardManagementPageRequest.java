package com.iyzipay.request;


import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class InitializeCardManagementPageRequest extends Request {

    private Boolean addNewCardEnabled;
    private Boolean validateNewCard;
    private String externalId;
    private String email;
    private String cardUserKey;
    private String callbackUrl;

    public Boolean getAddNewCardEnabled() {
        return addNewCardEnabled;
    }

    public void setAddNewCardEnabled(Boolean addNewCardEnabled) {
        this.addNewCardEnabled = addNewCardEnabled;
    }

    public Boolean getValidateNewCard() {
        return validateNewCard;
    }

    public void setValidateNewCard(Boolean validateNewCard) {
        this.validateNewCard = validateNewCard;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardUserKey() {
        return cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("addNewCardEnabled", addNewCardEnabled)
                .append("validateNewCard", validateNewCard)
                .append("externalId", externalId)
                .append("email", email)
                .append("cardUserKey", cardUserKey)
                .append("callbackUrl", callbackUrl)
                .toString();
    }
}
