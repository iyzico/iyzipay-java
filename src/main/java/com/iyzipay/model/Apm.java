package com.iyzipay.model;

import com.iyzipay.HashValidator;
import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.ResponseSignatureGenerator;
import com.iyzipay.request.CreateApmInitializeRequest;
import com.iyzipay.request.RetrieveApmRequest;

import java.util.Arrays;

public class Apm extends ApmResource implements ResponseSignatureGenerator {

    public boolean verifyChecksumForCreate(String secretKey) {
        String calculated = generateSignature(secretKey, Arrays.asList(getPaymentId(), getRedirectUrl()));
        return HashValidator.hashValid(getChecksum(), calculated);
    }

    public static Apm create(CreateApmInitializeRequest request, Options options) {
        String path = "/payment/apm/initialize";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Apm.class);
    }

    public boolean verifyChecksumForRetrieve(String secretKey) {
        String calculated = generateSignature(secretKey,
                Arrays.asList(getCurrency(), getBasketId(),
                        getConversationId(), getPaidPrice(),
                        getPrice(), getPaymentId(), getRedirectUrl()));
        return HashValidator.hashValid(this.getChecksum(), calculated);
    }

    public static Apm retrieve(RetrieveApmRequest request, Options options) {
        String path = "/payment/apm/retrieve";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Apm.class);
    }
}
