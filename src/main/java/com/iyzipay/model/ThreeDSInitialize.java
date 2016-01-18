package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectThreeDSInitializeRequest;

public class ThreeDSInitialize extends IyzipayResource {

    private String htmlContent;

    public static ThreeDSInitialize create(CreateConnectThreeDSInitializeRequest request, Options options) {
        ThreeDSInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/initialize3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDSInitialize.class)
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
