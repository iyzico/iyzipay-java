package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

import java.util.Arrays;

public class PaymentPostAuth extends PaymentResource implements ResponseSignatureGenerator {

    public boolean verifyChecksum(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getPaymentId(), getCurrency(), getBasketId(),
                        getConversationId(), getPaidPrice(), getPrice()));
        return HashValidator.hashValid(getChecksum(), calculated);
    }

    public static PaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        String path = "/payment/postauth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPostAuth.class);
    }
}
