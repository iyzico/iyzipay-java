package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreatePaymentRequest;

import java.util.Arrays;

public class ThreedsInitialize extends IyzipayResource implements ResponseSignatureGenerator {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;
    private String paymentId;
    private String signature;
    private String threeDsRedirectionUrl;

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentId(), getConversationId()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static ThreedsInitialize create(CreatePaymentRequest request, Options options) {
        String path = "/payment/3dsecure/initialize";
        ThreedsInitialize response = HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                ThreedsInitialize.class);
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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getThreeDsRedirectionUrl() {
        return threeDsRedirectionUrl;
    }

    public void setThreeDsRedirectionUrl(String threeDsRedirectionUrl) {
        this.threeDsRedirectionUrl = threeDsRedirectionUrl;
    }

}
