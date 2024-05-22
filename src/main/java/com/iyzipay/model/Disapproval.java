package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateApprovalRequest;

public class Disapproval extends IyzipayResource {

    private String paymentTransactionId;

    public static Disapproval create(CreateApprovalRequest request, Options options) {
        String path = "/payment/iyzipos/item/disapprove";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                Disapproval.class);
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }
}
