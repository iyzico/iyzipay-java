package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBKMInitializeRequest;

public class BKMInitialize extends IyzipayResource {

    private String htmlContent;

    public static BKMInitialize create(CreateBKMInitializeRequest request, Options options) {
        BKMInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/bkm/initialize/ecom",
                getHttpHeaders(request, options),
                request,
                BKMInitialize.class);
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
