package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.RetrieveBkmRequest;

import java.util.Arrays;

public class Bkm extends PaymentResource implements ResponseSignatureGenerator {

    private String token;
    private String callbackUrl;

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentId(), getPaymentStatus(),
                        getBasketId(), getConversationId(), getCurrency(),
                        getPaidPrice(), getPrice(), getToken()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static Bkm retrieve(RetrieveBkmRequest request, Options options) {
        String path = "/payment/bkm/auth/detail";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Bkm.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
