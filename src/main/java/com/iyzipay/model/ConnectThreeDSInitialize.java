package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectThreeDSInitializeRequest;

public class ConnectThreeDSInitialize extends IyzipayResource {

    private String htmlContent;

    public static ConnectThreeDSInitialize create(CreateConnectThreeDSInitializeRequest request, Options options) {
        ConnectThreeDSInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/initialize3ds",
                getHttpHeaders(request, options),
                request,
                ConnectThreeDSInitialize.class)
                .getBody();
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
