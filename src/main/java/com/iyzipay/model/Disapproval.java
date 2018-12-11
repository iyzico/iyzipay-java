package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateApprovalRequest;

public class Disapproval extends IyzipayResource {

    private String paymentTransactionId;

    public static Disapproval create(CreateApprovalRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/item/disapprove",
                getHttpProxy(options),
                getHttpHeaders(request, options),
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
