package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

import java.util.Arrays;

public class PaymentPreAuth extends PaymentResource implements ResponseSignatureGenerator {

    public boolean verifySignature(String secretKey){
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentId(), getCurrency(), getBasketId(),
                        getConversationId(), getPaidPrice(), getPrice()));
        return HashValidator.hashValid(getSignature(), calculated);
    }


    public static PaymentPreAuth create(CreatePaymentRequest request, Options options) {
        String path = "/payment/preauth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPreAuth.class);
    }

    public static PaymentPreAuth retrieve(RetrievePaymentRequest request, Options options) {
        String path = "/payment/detail";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPreAuth.class);
    }
}
