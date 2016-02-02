package com.iyzipay;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

public class IyzipayResource {

    private static final String AUTHORIZATION = "Authorization";
    private static final String RANDOM_HEADER_NAME = "x-iyzi-rnd";
    private static final String IYZIWS_HEADER_NAME = "IYZWS ";
    private static final String COLON = ":";
    private static final int RANDOM_STRING_SIZE = 8;

    private String status;
    private String errorCode;
    private String errorMessage;
    private String errorGroup;
    private String locale;
    private long systemTime;
    private String conversationId;

    public IyzipayResource() {
    }

    protected static List<Header> getHttpHeaders(Request request, Options options) {
        String randomString = System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(RANDOM_STRING_SIZE);
        List<Header> httpHeaders = new ArrayList<Header>();
        Header randomHeader = new BasicHeader(RANDOM_HEADER_NAME, randomString);
        Header authorizationHeader = new BasicHeader(AUTHORIZATION, prepareAuthorizationString(request, randomString, options));
        httpHeaders.add(randomHeader);
        httpHeaders.add(authorizationHeader);
        return httpHeaders;
    }

    private static String prepareAuthorizationString(Request request, String randomString, Options options) {
        String hash = HashGenerator.generateHash(options.getApiKey(), options.getSecretKey(), randomString, request);
        return IYZIWS_HEADER_NAME + options.getApiKey() + COLON + hash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorGroup() {
        return errorGroup;
    }

    public void setErrorGroup(String errorGroup) {
        this.errorGroup = errorGroup;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
