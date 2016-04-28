package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicThreeDSInitialize extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static BasicThreeDSInitialize create(CreateBasicPaymentRequest request, Options options) {
        BasicThreeDSInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/initialize3ds",
                getHttpHeaders(request, options),
                request,
                BasicThreeDSInitialize.class);
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
