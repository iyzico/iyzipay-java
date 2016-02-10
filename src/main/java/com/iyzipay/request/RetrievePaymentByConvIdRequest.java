package com.iyzipay.request;

import com.iyzipay.Request;
import com.iyzipay.ToStringRequestBuilder;

public class RetrievePaymentByConvIdRequest extends Request {

    private String paymentConversationId;

    public String getPaymentConversationId() {
        return paymentConversationId;
    }

    public void setPaymentConversationId(String paymentConversationId) {
        this.paymentConversationId = paymentConversationId;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("paymentConversationId", paymentConversationId)
                .toString();
    }
}
