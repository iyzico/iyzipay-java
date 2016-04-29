package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class CreateThreedsPaymentRequest extends Request {

    private String paymentId;
    private String conversationData;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getConversationData() {
        return conversationData;
    }

    public void setConversationData(String conversationData) {
        this.conversationData = conversationData;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("paymentId", paymentId)
                .append("conversationData", conversationData)
                .toString();
    }
}
