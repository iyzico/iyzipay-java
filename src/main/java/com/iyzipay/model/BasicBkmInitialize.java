package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicBkmInitializeRequest;

public class BasicBkmInitialize extends IyzipayResource {

    private String htmlContent;
    private String token;

    public static BasicBkmInitialize create(CreateBasicBkmInitializeRequest request, Options options) {
        String path = "/payment/bkm/initialize/basic";
        BasicBkmInitialize response = HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicBkmInitialize.class);
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
