package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrievePaymentRequest;

public class PaymentRetrieval extends Payment {

    private String paymentStatus;

    public static PaymentRetrieval retrieveByPaymentId(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/retrieve",
                getHttpHeaders(request, options),
                request,
                PaymentRetrieval.class)
                .getBody();
    }

    public static PaymentRetrieval retrieveByConversationId(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/retrieve-by-conversation-id",
                getHttpHeaders(request, options),
                request,
                PaymentRetrieval.class)
                .getBody();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
