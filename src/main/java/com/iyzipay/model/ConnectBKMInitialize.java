package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectBKMInitializeRequest;

public class ConnectBKMInitialize extends IyzipayResource {

    private String htmlContent;

    public static ConnectBKMInitialize create(CreateConnectBKMInitializeRequest request, Options options) {
        ConnectBKMInitialize response = options.getHttpClient().post(options.getBaseUrl() + "/payment/iyziconnect/bkm/initialize",
                getHttpHeaders(request, options),
                request,
                ConnectBKMInitialize.class);
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
