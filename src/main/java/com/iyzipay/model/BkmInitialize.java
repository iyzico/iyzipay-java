package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreateBkmInitializeRequest;

import java.util.Arrays;

public class BkmInitialize extends IyzipayResource implements ResponseSignatureGenerator {

    private String htmlContent;
    private String token;
    private String signature;

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey, Arrays.asList(getToken(), getConversationId()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static BkmInitialize create(CreateBkmInitializeRequest request, Options options) {
        String path = "/payment/bkm/initialize";
        BkmInitialize response = HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BkmInitialize.class);
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
