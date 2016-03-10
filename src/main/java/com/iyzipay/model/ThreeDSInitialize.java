package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSInitializeRequest;

public class ThreeDSInitialize extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static ThreeDSInitialize create(CreateThreeDSInitializeRequest request, Options options) {
        ThreeDSInitialize response = httpClient.post(options.getBaseUrl() + "/payment/iyzipos/initialize3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDSInitialize.class);
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
