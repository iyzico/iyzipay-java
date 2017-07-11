package com.iyzipay.functional.builder.request;

import com.iyzipay.model.Locale;

public abstract class BaseRequestBuilder {

    protected String locale = Locale.TR.getValue();
    protected String conversationId = "123456789";
}
