package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectThreeDSInitializeRequest;

public class ConnectThreeDSInitialize extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static ConnectThreeDSInitialize create(CreateConnectThreeDSInitializeRequest request, Options options) {
        ConnectThreeDSInitialize response = options.getHttpClient().post(options.getBaseUrl() + "/payment/iyziconnect/initialize3ds",
                getHttpHeaders(request, options),
                request,
                ConnectThreeDSInitialize.class);
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
