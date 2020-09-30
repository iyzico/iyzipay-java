package com.iyzipay ;

import static org.apache.commons.lang3.StringUtils.isNotBlank ;

import java.net.InetSocketAddress ;
import java.net.Proxy ;
import java.util.HashMap ;
import java.util.Map ;
import java.util.UUID ;

import org.apache.commons.lang3.RandomStringUtils ;
import org.apache.commons.lang3.StringUtils ;
import org.apache.commons.lang3.builder.ToStringBuilder ;
import org.apache.commons.lang3.builder.ToStringStyle ;

public class IyzipayResource {

    private static final String AUTHORIZATION = "Authorization";
    private static final String RANDOM_HEADER_NAME = "x-iyzi-rnd";
    private static final String CLIENT_VERSION_HEADER_NAME = "x-iyzi-client-version";
    private static final String IYZIWS_HEADER_NAME = "IYZWS ";
    private static final String IYZIWS_V2_HEADER_NAME = "IYZWSv2 ";
    private static final String CLIENT_VERSION = IyzipayResource.class.getPackage().getImplementationVersion();
    private static final String CLIENT_TITLE = IyzipayResource.class.getPackage().getImplementationTitle();
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

    protected static Map<String, String> getHttpHeaders(Request request, Options options) {
        Map<String, String> headers = new HashMap<String, String>();

        String randomString = System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(RANDOM_STRING_SIZE);
        headers.put(RANDOM_HEADER_NAME, randomString);
        headers.put(AUTHORIZATION, prepareAuthorizationString(request, randomString, options));

        putClientVersionHeader(headers);
        return headers;
    }

    protected static Map<String, String> getHttpHeadersV2(String uri, Request request, Options options) {
        Map<String, String> headers = new HashMap<String, String>();

        String randomString = UUID.randomUUID().toString();
        headers.put(AUTHORIZATION, prepareAuthorizationStringV2(uri, request, randomString, options));

        putClientVersionHeader(headers);
        return headers;
    }

    protected static Proxy getHttpProxy(Options options) {
        if (isNotBlank(options.getProxyHost())) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(options.getProxyHost(), options.getProxyPort())) ;
        }
        return null ;
    }

    private static void putClientVersionHeader(Map<String, String> headers) {
        if (StringUtils.isNoneBlank(CLIENT_VERSION, CLIENT_TITLE)) {
            headers.put(CLIENT_VERSION_HEADER_NAME, CLIENT_TITLE + "-" + CLIENT_VERSION);
        }
    }

    private static String prepareAuthorizationString(Request request, String randomString, Options options) {
        String hash = HashGenerator.generateHash(options.getApiKey(), options.getSecretKey(), randomString, request);
        return IYZIWS_HEADER_NAME + options.getApiKey() + COLON + hash;
    }

    private static String prepareAuthorizationStringV2(String uri, Request request, String randomString, Options options) {
        String authContent = IyziAuthV2Generator.generateAuthContent(uri, options.getApiKey(), options.getSecretKey(), randomString, request);
        return IYZIWS_V2_HEADER_NAME + authContent;
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
