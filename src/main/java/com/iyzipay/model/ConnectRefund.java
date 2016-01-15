package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateRefundRequest;

public class ConnectRefund extends Refund {

    private String connectorName;

    public static ConnectRefund create(CreateRefundRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/refund",
                getHttpHeaders(request, options),
                request,
                ConnectRefund.class)
                .getBody();
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
}
