package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;

import java.util.Arrays;


public class PayWithIyzicoInitialize extends PayWithIyzicoInitializeResource implements ResponseSignatureGenerator {

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getConversationId(), getToken()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static PayWithIyzicoInitialize create(PayWithIyzicoInitializeRequest request, Options options) {
        String path = "/payment/pay-with-iyzico/initialize";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PayWithIyzicoInitialize.class);
    }
}
