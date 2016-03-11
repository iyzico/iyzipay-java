package com.iyzipay.model;

import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateApprovalRequest;

public class Disapproval extends IyzipayResource {

    private String paymentTransactionId;

    public static Disapproval create(CreateApprovalRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/iyzipos/item/disapprove",
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
