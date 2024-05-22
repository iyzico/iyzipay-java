package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreedsPaymentRequest;
import com.iyzipay.request.CreateThreedsPaymentRequestV2;
import com.iyzipay.request.RetrievePaymentRequest;

public class ThreedsPayment extends PaymentResource {

    public static ThreedsPayment create(CreateThreedsPaymentRequest request, Options options) {
        String path = "/payment/3dsecure/auth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                ThreedsPayment.class);
    }

    public static ThreedsPayment createV2(CreateThreedsPaymentRequestV2 request, Options options) {
        String path = "/payment/v2/3dsecure/auth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                ThreedsPayment.class);
    }

    public static ThreedsPayment retrieve(RetrievePaymentRequest request, Options options) {
        String path = "/payment/detail";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                ThreedsPayment.class);
    }
}
