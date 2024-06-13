package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreateCheckoutFormInitializeRequest;

import java.util.Arrays;

public class CheckoutFormInitializePreAuth extends CheckoutFormInitializeResource implements ResponseSignatureGenerator {

    public boolean verifyChecksum(String secretKey){
        String calculated = generateSignature(secretKey,
                Arrays.asList(getConversationId(), getToken()));
        return HashValidator.hashValid(getChecksum(), calculated);
    }

    public static CheckoutFormInitializePreAuth create(CreateCheckoutFormInitializeRequest request, Options options) {
        String path = "/payment/iyzipos/checkoutform/initialize/preauth/ecom";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                CheckoutFormInitializePreAuth.class);
    }
}
