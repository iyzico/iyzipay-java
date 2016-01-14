package com.iyzipay;

public class Request {

    private String locale;
    private String conversationId;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("locale", locale)
                .append("conversationId", conversationId)
                .toString();
    }
}
