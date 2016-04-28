package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicThreeDSInitializePreAuth extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static BasicThreeDSInitializePreAuth create(CreateBasicPaymentRequest request, Options options) {
        BasicThreeDSInitializePreAuth response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/initialize3ds/preauth",
                getHttpHeaders(request, options),
                request,
                BasicThreeDSInitializePreAuth.class);
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
