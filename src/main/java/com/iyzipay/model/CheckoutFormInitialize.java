package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

import java.util.Arrays;

public class CheckoutFormInitialize extends CheckoutFormInitializeResource implements ResponseSignatureGenerator {

    public boolean verifySignature(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getConversationId(), getToken()));
        return HashValidator.hashValid(getSignature(), calculated);
    }

    public static CheckoutFormInitialize create(CreateCheckoutFormInitializeRequest request, Options options) {
        String path = "/payment/iyzipos/checkoutform/initialize/auth/ecom";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CheckoutFormInitialize.class);
    }
}
