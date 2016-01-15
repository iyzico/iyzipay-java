package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateCancelRequest;

public class ConnectCancel extends Cancel {

    private String connectorName;

    public static ConnectCancel create(CreateCancelRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/cancel",
                getHttpHeaders(request, options),
                request,
                ConnectCancel.class)
                .getBody();
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

}
