package com.iyzipay.request.masspayout;

import com.iyzipay.Request;

public class MassPayoutAuthRequest extends Request {
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "MassPayoutAuthRequest{" +
                "requestId='" + requestId + '\'' +
                '}';
    }
}